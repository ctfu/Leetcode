/* the cocept is that: buying and selling stacks has time stamp requirements,
you have to buy it earilier than when you can sell. so calculation has to start
from the beging of the array */
public class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, max = 0;  //max for max profit
        for(int i = 0; i < prices.length; i++){
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }
        return max;
    }
}
