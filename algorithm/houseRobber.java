public class Solution {
    //it's a 0/1 dynamic programming problem, rob or dont rob the house
    public int rob(int[] nums) {
        int[][] dp = new int[nums.length + 1][2];
        for(int i = 1; i <= nums.length; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);/*dont rob, you have dicision to rob or dont rob the previous */
            dp[i][1] = nums[i-1] + dp[i-1][0];  /* rob,you must not rob previous, nums[i-1] means the num starting from index 0 */
        }
        /* return the max till the last house decision */
        return Math.max(dp[nums.length][0], dp[nums.length][1]);
    }
}

//convert to O(1) space
public class Solution {
    //it's a 0/1 dynamic programming problem, rob or dont rob the house
    public int rob(int[] nums) {
       int preNo = 0; /* dont rob */
       int preYes = 0; /* rob */
       for(int money : nums){
           int temp = preNo;
           preNo = Math.max(preNo, preYes);
           preYes = money + temp;
       }
       return Math.max(preNo, preYes);
    }
}
