/* Idea: comb[target] = sum(comb[target-nums[i]{0<=i<nums.length}])
 * dp[i]: indicates the number of combination sums to i
 * dp[i] = sum(dp[i-nums[j]{j<=0<nums.length}])
 * Note: dp[0] = 1, the number of combination sum to 0 is 1 */
public class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[]dp = new int[target+1];
        dp[0] = 1; /* initialize dp[0] */
        for(int i = 1; i <= target; i++){
            for(int j = 0; j < nums.length; j++){
                if(i-nums[j] >= 0){ /* important to check bound */
                    dp[i] += dp[i - nums[j]]; /* sum of combination dp[i-nums[j]] */
                }
            }
        }
        return dp[target];
    }
}
