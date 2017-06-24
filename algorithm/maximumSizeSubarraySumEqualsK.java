/* Approach: HashMap: store the accumulated sum and corresponding index
 * search hashmap for sum - k
 * time complexity: O(n), space complexity: O(n)
 */
public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        hm.put(0, -1);
        int sum = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (hm.containsKey(sum - k)) {
                max = Math.max(max, i - hm.get(sum - k));
            }
            /* here check hashmap not contains then store, is because nums contains negative number
             * so the sum may contain duplicate, but we want the earliest index */
            if (!hm.containsKey(sum)) {
                hm.put(sum, i);
            }
        }
        return max;
    }
}
