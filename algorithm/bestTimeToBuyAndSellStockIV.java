class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        // since buy and sell needs to happen in different times, when k >= prices.length / 2
        // it meas we are conducting as many transactions as we can (probelm best time to buy and sell stack II)
        if (k >= prices.length / 2) {
            int res = 0;
            for (int i = 0; i < prices.length - 1; i++) {
                if (prices[i + 1] - prices[i] > 0) {
                    res += prices[i + 1] - prices[i];
                }
            }
            return res;
        }
        int[][] dp = new int[k + 1][prices.length];
        for (int t = 1; t <= k; t++) {
            int tempMax = -prices[0]; // buy stock
            for (int p = 1; p < prices.length; p++) {
                dp[t][p] = Math.max(dp[t][p-1], tempMax + prices[p]); // do nothing or sell it
                tempMax = Math.max(tempMax, dp[t-1][p - 1] - prices[p]); // whether to buy or not
            }
        }
        return dp[k][prices.length - 1];
    }
}
