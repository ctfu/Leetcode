/* using comparotro instead of lambda expression is a lot faster */
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        ArrayList<Node> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();

        Arrays.sort(nums);
        int count = 1;
        for(int i = 0; i < nums.length-1; i++){
            if(nums[i] == nums[i+1]){
                count++;
            }else{
                list.add(new Node(nums[i], count));
                count = 1;
            }
        }

        list.add(new Node(nums[nums.length -1], count));
        /*Collections.sort(list, (a, b) -> b.frequency - a.frequency); */
        Collections.sort(list, new Comparator<Node>(){  /* using comparator */
            @Override
            public int compare(Node a, Node b){
                return b.frequency - a.frequency;
            }
        });
        int index = 0;
        while(k > 0){
           res.add(list.get(index++).element);
           k--;
        }
        return res;
    }
    private class Node{
        int element;
        int frequency;
        public Node(int element, int frequency){
            this.element = element;
            this.frequency = frequency;
        }
    }
}

/* second solution is to use bucket sort */
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer>[] buckets = new List[nums.length + 1]; /* an List<Integer> array for buckets */
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1); /* this map collectes the element and its frequency */
        }
        for(int key : map.keySet()){
            int freq = map.get(key);
            if(buckets[freq] == null){
               buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(key);
        }
        for(int i = buckets.length -1; i >= 0; i--){
            if(buckets[i] != null){
                for(int j = 0; j < buckets[i].size() && res.size() < k; j++){
                    res.add(buckets[i].get(j));
                }
            }
        }
        return res;
    }
}
