/* DP problem
 * dp[i] - indicates the maxSum till index i
 * dp[i] = (dp[i-1] > 0 ? dp[i-1] : 0) + nums[i]
 * to calculate dp[i], there are only two choices, either add dp[i-1] to nums[i] or not
 * if dp[i-1] is negative, it only makes sum smaller, so only added when positive  */
public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int maxSum = dp[0];
        for(int i = 1; i < nums.length; i++){
            dp[i] = nums[i] + (dp[i-1] > 0 ? dp[i-1] : 0);
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }
}

/* since we are only using one accumulated previous result,
 * we can reduce the space to o(1) */
 public class Solution{
     public int maxSubArray(int[] nums){
         if(nums == null || nums.length == 0){
             return 0;
         }
         int maxSum = nums[0];
         int sum = nums[0];
         for(int i = 1; i < nums.length; i++){
             if(sum < 0){
                 sum = nums[i];
             }else{
                 sum += nums[i];
             }
             maxSum = Math.max(maxSum, sum);
         }
         return maxSum;
     }
 }
