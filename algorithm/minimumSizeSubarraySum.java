/* Approach: two pointer starting from begining
 * time complexity: O(n), space complexity: O(1)
 */
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int begin = 0, end = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        while (end < nums.length) {
            sum += nums[end++];
            while (sum >= s) {  // reduce the size when sum >= s
               res = Math.min(res, end - begin);
               sum -= nums[begin++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
