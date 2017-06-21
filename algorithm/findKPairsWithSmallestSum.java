/* PriorityQueue (minHeap) + custome Pair object, time complexity O(klogn)*/
public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k < 1) return res;
        PriorityQueue<Pair> queue = new PriorityQueue<>((a,b) -> a.sum-b.sum);  /* sorted on sum */
        /* build a heap with all pairs with first num in the first array */
        for(int i = 0; i < nums2.length; i++){
            queue.offer(new Pair(0, i, nums1[0]+nums2[i]));
        }
        /* Find k pairs by repeat operation k time or nums1.length * nums2.length time,
         * k could be greater than all possible pairs */
        for(int i = 0; i < Math.min(k, nums1.length * nums2.length); i++){
            Pair top = queue.poll();
            res.add(new int[]{nums1[top.x], nums2[top.y]});
            if(top.x == nums1.length-1) continue; /* need to continue for not getting enough k pairs */
            queue.offer(new Pair(top.x+1, top.y, nums1[top.x+1]+nums2[top.y]));
        }
        return res;
    }
    /* custome object Pair */
    class Pair{
        int x;  /* position of num in first array */
        int y;  /* position of num in the second array */
        int sum;/* sum of these two numbers */
        public Pair(int x, int y, int sum){
            this.x = x;
            this.y = y;
            this.sum = sum;
        }
    }
}
