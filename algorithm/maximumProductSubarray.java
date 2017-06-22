/* Approach: Keep a local max, and local min to the index number reached so far
 * time complexity: O(n), space complexity: O(1)
 */
public class Solution {
    public int maxProduct(int[] nums) {
        int preMax = nums[0];
        int preMin = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int max = preMax, min = preMin;
            preMax = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            preMin = Math.min(Math.min(max * nums[i], min * nums[i]), nums[i]);
            res = Math.max(res, preMax);
        }
        return res;
    }
}
