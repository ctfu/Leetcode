/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like
(ie, buy one and sell one share of the stock multiple times) with the following restrictions:

You may not engage in multiple transactions at the same time
(ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
Example:

Input: [1,2,3,0,2]
Output: 3
Explanation: transactions = [buy, sell, cooldown, buy, sell]
*/
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int[][] dp = new int[prices.length][3];

        /* maintain three states, 0->buy, 1->sell, 2->cooldown
         * dp[i][state]: indicates the max profit at that states */
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        for (int i = 1; i < prices.length; i++) {
            //max profit with lowest purchased price
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][2] - prices[i]);//can only buy after cooldown
            // max profit with sell or keep
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i]);
            // max profit at holddown state
            dp[i][2] = dp[i-1][1];
        }
        return Math.max(dp[prices.length-1][1], dp[prices.length-1][2]);
    }
}
