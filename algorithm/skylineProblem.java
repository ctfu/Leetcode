/* 1. seperate each building into building points with {start, -height}, {end, height}
 * 2. maxHeap to keep tract of the max height for the previous buildings
 * 3. if start of the building, push height to maxHeap, else remove building point's height from the heap
 * 4. if the height changes by step 3 operation, include a point to result set */
public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        List<int[]> buildingPoints = new ArrayList<>();
        for(int[] b : buildings){   /* for each building, sepearte into start, and building points */
            buildingPoints.add(new int[]{b[0], -b[2]}); /* use negative to differentiat from end point */
            buildingPoints.add(new int[]{b[1], b[2]});
        }
        /* sort buildingPoints by x position */
        Collections.sort(buildingPoints, (a, b)->{
           if(a[0] != b[0]){
               return a[0] - b[0]; /* if not overlap, sort x increasing order */
           }else{
               /* if overlap on start, sort y decreasing order. negative a[1]-negative b[1] = b[1] - a[1]
                * if overlap on end, sort y increasing order */
               return a[1] - b[1];
           }
        });
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.offer(0); /* inital building height */
        int preMax = 0;
        for(int[] bp : buildingPoints){
            if(bp[1] < 0){  /* if is start of building */
                maxHeap.offer(-bp[1]); /* push to the heap, important to reverse it back */
            }else{
                maxHeap.remove(bp[1]); /* else remove from the heap */
            }
            int curHeight = maxHeap.peek();
            if(curHeight != preMax){    /* if maxHeight changes */
                res.add(new int[]{bp[0], curHeight});
                preMax = curHeight;
            }
        }
        return res;
    }
}

/* Due to PriorityQueue removing random node takes o(n), use TreeMap (add, remove, search o(logn)) */
TreeMap<Integer, Integer> heightMap = new TreeMap<>(Collections.reverseOrder());
heightMap.put(0, 1);
int preMax = 0;
for(int[] bp : buildingPoints){
    if(bp[1] < 0){
        heightMap.put(-bp[1], heightMap.getOrDefault(-bp[1], 0)+1);
    }else{
        Integer cnt = heightMap.get(bp[1]); /* here wont reture null, because buildingPoints sorted based on start */
        if(cnt == 1){   /* important to check if it is the only one */
            heightMap.remove(bp[1]);
        }else{
            heightMap.put(bp[1], cnt-1);
        }
    }
    int curHeight = heightMap.firstKey();
    if(curHeight != preMax){
        res.add(new int[]{bp[0], curHeight});
        preMax = curHeight;
    }
}
