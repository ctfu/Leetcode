/* DP Solution
 * table[i][j] definition: minimum money to guarantee win
 * For any range [i,j], if pick a number k in between, to guarantee a win,
 * outcome(k) = k + max(outcome(i~k-1), outcome(k+1, j))
 * The minimum money to win becomes: min(i<=k<=j){outcome(i), ...outcome(j)} */
public class Solution {
    public int getMoneyAmount(int n) {
        if(n == 1) return 0;
        int[][] table = new int[n+1][n+1];
        for(int j = 2; j <= n; j++){
            for(int i = j-1; i > 0; i--){ /* a range [i,j] is formed here */
                int globalMin = Integer.MAX_VALUE;
                for(int k = i+1; k < j; k++){ /* picking a number k in [i,j] */
                    int localMax = k + Math.max(table[i][k-1], table[k+1][j]);
                    globalMin = Math.min(globalMin, localMax); /* update mini guarantee */
                }
                table[i][j] = i+1 == j ? i : globalMin;/* store the result */
                /* i+1 == j: means if there are only two number ,no space to
                 to pick a number k, i.e. [6, 7],pick i, because i is smaller */
            }
        }
        return table[1][n];
    }
}
