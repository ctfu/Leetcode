/* Note:
 * 1. By only move down and right, a cell can only get value from upper cell or left cell
 * 2. Exception is the first row and column, they only have only source direction, so need to initialize first
 * dp[i][j]: indicates the unique paths in cell[i][j]
 * dp[i][j] = dp[i-1][j] + dp[i][j-1];  */
public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        /* initialize the base case */
        for(int i = 0; i < m; i++){
            dp[i][0] = 1;
        }
        for(int i = 0; i < n; i++){
            dp[0][i] = 1;
        }
        /* apply dp optimal substructure */
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}


/* Improve space to o(n) */
public class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n]; /* using one dimention array to store */
        for(int i = 0; i < n; i++){
            dp[i] = 1;
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[j] += dp[j-1];
            }
        }
        return dp[n-1];
    }
}
