/* the concept here is that you can only buy stack from today to future
so the problem becomes whether you should buy the stock today. if tomorrow's
price is higher than today then you should buy it for maximum profits */
public class Solution {
    public int maxProfit(int[] prices) {
        int profits = 0;
        for(int i = 0; i < prices.length-1; i++){
            int earned = prices[i+1] - prices[i];
            if(earned > 0) profits += earned;
        }
        return profits;
    }
}
