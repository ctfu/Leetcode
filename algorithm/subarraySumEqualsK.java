/* Approach: HashMap to store sum and its count frequency, search for sum - k
 * similar to Leetcode Maximum Size Subarray Sum Equals K
 * time complexity: O(n), space complexity: O(n)
 */
public class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1);   // sum == 0, frequency is 1
        int sum = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (hm.containsKey(sum - k)) {
                res += hm.get(sum - k);
            }
            hm.put(sum, hm.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
