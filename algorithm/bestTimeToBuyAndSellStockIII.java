/* dp[t][i]: indicates the maximum profits by conducting at most t transactions up to price at index i
 * dp[t][i] = Math.max(dp[t][i-1], prices[i] - prices[j] + dp[t-1][j]) for 0 <= j < i,
 * the maximum profits that sells at price[i]
 * Explain: For each price, I can choose to sell or keep, if I do want to see,
 * In case I  want to sell, my purchased price need to be the lowest before today's price
 * so I will need to keep track of the lowest purchase price
 * Goal: dp[t][price.length-1] */
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1) return 0;

        int transactions = 2;
        int[][] dp = new int[transactions+1][prices.length];
        for(int t = 1; t <= transactions; t++){
            // max profit with current lowest purchase price
            int curMaxProfit = dp[t-1][0] - prices[0];
            for(int i = 1; i < prices.length; i++){ // start with the second price
                // choose to sell or keep
                dp[t][i] = Math.max(dp[t][i-1], prices[i] + curMaxProfit);
                // keep track of the current max profit with lowest purchase price
                curMaxProfit = Math.max(curMaxProfit, dp[t-1][i] - prices[i]);
            }
        }
        return dp[transactions][prices.length-1];
    }
}

/* Approach 2: seperate each trsaction into buy, and sell */
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1) return 0;

        int buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
        int sell1 = 0, sell2 = 0;
        /* buy1, buy2, sell1, sell2, are the maximum profits of buy first stock,
         * buy second stock, sell first stock, sell second stock */
        for(int p : prices){
            sell2 = Math.max(sell2, buy2 + p);
            buy2 = Math.max(buy2, sell1 - p);
            sell1 = Math.max(sell1, buy1 + p);
            buy1 = Math.max(buy1, -p);
        }
        return sell2;
    }
}
