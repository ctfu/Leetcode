/* Similar to paintHouse I, here uses two color index min1, min2 to keep track of the
 * smallest color cost, and second smallest color cost for each house painted
 * if current house painted color index == min1, then plus costs with color index min2
 * if current house painted color index != min1, then plus costs with color index min1*/
public class Solution {
    public int minCostII(int[][] costs) {
        if(costs.length == 0 || costs[0].length == 0) return 0;
        int min1 = -1, min2 = -1;
        for(int i = 0; i < costs.length; i++){
            int last1 = min1, last2 = min2;
            min1 = -1;  /* reset the index for each row */
            min2 = -1;
            for(int j = 0; j < costs[i].length; j++){
                if(j == last1){
                    costs[i][j] += last2 < 0 ? 0 : costs[i-1][last2];/* last1 < 0, indicates the first row */
                }else{
                    costs[i][j] += last1 < 0 ? 0 : costs[i-1][last1];
                }
                /* find min1 and min2 for each house */
                if(min1 < 0 || costs[i][j] < costs[i][min1]){/* min1 < 0, assign the min index to the first color index */
                    min2 = min1;
                    min1 = j;
                }else if(min2 < 0 || costs[i][j] < costs[i][min2]){
                    min2 = j;
                }
            }
        }
        return costs[costs.length-1][min1];
    }
}
