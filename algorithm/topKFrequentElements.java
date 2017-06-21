/* Method 1: HashMap + maxHeap (priorityQueue) o(nlogk)*/
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;

        Map<Integer, Integer> hm = new HashMap<>();
        /* a priorityQueue to store each entry for the map */
       /*PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue(k, (a, b) -> b.getValue()-a.getValue());*/
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue(k,
                        new Comparator<Map.Entry<Integer, Integer>>(){
            @Override
            public int compare(Map.Entry<Integer, Integer> entry1, Map.Entry<Integer, Integer> entry2){
                return entry2.getValue() - entry1.getValue();
            }
        });
        /* hm count the frequency */
        for(int num : nums){
            hm.put(num, hm.getOrDefault(num, 0)+1);
        }
        /* put entry to the heap */
        for(Map.Entry<Integer, Integer> entry : hm.entrySet()){
            maxHeap.offer(entry);
        }
        /* extract k size from the heap */
        while(res.size() < k){
            res.add(maxHeap.poll().getKey());
        }
        return res;
    }
}

/* Method 2: HashMap + buckets (List of ArrayList) o(n)*/
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;

        Map<Integer, Integer> hm = new HashMap<>();
        List<Integer>[] buckets = new List[nums.length + 1]; /* initialize an array of List */
        for(int num : nums){
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        /* frequency as the bucket index */
        for(int key : hm.keySet()){
            int frequency = hm.get(key);
            if(buckets[frequency] == null){
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);
        }
        /* later index of bucket has greater frequency */
        for(int i = buckets.length-1; i >= 0; i--){
            if(buckets[i] != null && res.size() < k){
                /* res.addAll(buckets[i]); /* this way could add more than k elements */
                for(int j = 0; j < buckets[i].size() && res.size() < k; j++){
                    res.add(buckets[i].get(j));
                }
            }
        }
        return res;
    }
}
