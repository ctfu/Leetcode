/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like
(i.e., buy one and sell one share of the stock multiple times).

Note: You may not engage in multiple transactions at the same time
(i.e., you must sell the stock before you buy again).
*/
public class Solution {
    public int maxProfit(int[] prices) {
        int profits = 0;
        for(int i = 0; i < prices.length-1; i++){
            /* if the price of tomorrow is going up, buy and sell it */
            int earned = prices[i+1] - prices[i];
            if(earned > 0) profits += earned;
        }
        return profits;
    }
}
