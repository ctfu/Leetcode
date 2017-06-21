/* Requirements: no adjacent two house can paint the same color
 * differnet than paint fence (no more than two ajacencent posts can have the same color)
 * Approach: Dynamic programming approach: dp[i][j]: minimum costs to paint i houses with last house of j color 
 * dp[i][j] = 1. when j = 0: dp[i][0] = costs[i][0] + Math.min(dp[i-1][1], dp[i-1][2])
            = 2. when j = 1: dp[i][1] = costs[i][1] + Math.min(dp[i-1][0], dp[i-1][2])
            = 3. when j = 2: dp[i][2] = costs[i][2] + Math.min(dp[i-1][0], dp[i-1][1])
 * Goal: Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2]))
 * Trick: instead of creating a dp table, we can utilized the existing costs table */
public class Solution {
    public int minCost(int[][] costs) {
        if(costs.length == 0 || costs[0].length == 0) return 0;
        int red = costs[0][0], blue = costs[0][1], green = costs[0][2];
        for(int i = 1; i < costs.length; i++){  /* culculate the costs sum from row 1(house 1) */
            int r = red, b = blue, g = green;
            red = costs[i][0] + Math.min(b, g);
            blue = costs[i][1] + Math.min(r, g);
            green = costs[i][2] + Math.min(r, b);
        }
        /* red, blue and green at the end represents the min sum for painting all the house
         * with the last house have different color */
        return Math.min(red, Math.min(blue, green));
    }
}
