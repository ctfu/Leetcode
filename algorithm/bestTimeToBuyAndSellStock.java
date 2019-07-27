/*
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction
(i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.
*/
/* Key concept: If I do want to sell at the current price, my purchased prices
 * must be the lowest price before. So I need to keep track of the lowest price */
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            // keep track of the lowest price
            minPrice = Math.min(minPrice, prices[i]);
        }
        return maxProfit;
    }
}
