/* Approach: HashMap */
class Solution {
    public int findLHS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> hm = new HashMap<>();
        int res = 0;
        // keep a counter for all the numbers
        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        // search hm for each key + 1
        for (int key : hm.keySet()) {
            if (hm.containsKey(key + 1)) {
               res = Math.max(res, hm.get(key + 1) + hm.get(key));
            }
        }
        return res;
    }
}
