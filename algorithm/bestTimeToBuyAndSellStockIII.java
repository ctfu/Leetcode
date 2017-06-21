/* dp[t][i]: indicates the maximum profits by conducting at most t transactions up to price at index i
 * dp[t][i] = Math.max(dp[t][i-1], prices[i] - prices[j] + dp[t-1][j]) for 0 <= j < i, the maximum profits that sells at price[i]
 * Explain: at each price, you can choose to do nothing, or sell it at this price, the maximum profits is the max of do nothing or
 * the max value of selling it at price[i] (which is the max of sell at price[i], while buy it from each previous price)
 * Note: dp[t][i-1]: do nothing at price[i], dp[t-1][j]: previous transaction before price[j], the reason j-1, is you can only buy
 * after you sell the stock
 * Goal: dp[t][price.length-1] */
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1) return 0;

        int transactions = 2;
        int[][] dp = new int[transactions+1][prices.length];
        for(int t = 1; t <= transactions; t++){
            int tempMax = dp[t-1][0] - prices[0];   /* buy the stock at price[0] */
            for(int i = 1; i < prices.length; i++){
                dp[t][i] = Math.max(dp[t][i-1], prices[i] + tempMax);   /* if sells at price[i] */
                tempMax = Math.max(tempMax, dp[t-1][i] - prices[i]);    /* update running localMax */
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
