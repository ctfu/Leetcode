/* Follow up change: if added obstacle in the grid as 1
 * Note: 1. if encouter dp[i][j] == 1, assign 0
 * Be careful in the base case initilization, if encounter 1, all the cells after the path should be 0 */
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length == 0 || obstacleGrid[0].length == 0){
            return 0;
        }
        int rows = obstacleGrid.length, cols = obstacleGrid[0].length;
        int[][] dp = new int[rows][cols];
        for(int i = 0; i < rows; i++){ /* init first column */
            if(obstacleGrid[i][0] == 1){
                dp[i][0] = 0;
                break; /* when meets 1, the rest cells has 0 unique paths */
            }else{
                dp[i][0] = 1;
            }
        }
        for(int i = 0; i < cols; i++){ /* init first row */
            if(obstacleGrid[0][i] == 1){
                dp[0][i] = 0;
                break;
            }else{
                dp[0][i] = 1;
            }
        }
        for(int i = 1; i < rows; i++){
            for(int j = 1; j < cols; j++){
                if(obstacleGrid[i][j] == 1){ /* if obstacle, assign 0 */
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[rows-1][cols-1];
    }
}

/* Method 2 */
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int width = obstacleGrid[0].length;
        int[] dp = new int[width];
        dp[0] = 1;      /* only initialize the first cell */
        for (int[] row : obstacleGrid) {    /* row by row */
            for (int j = 0; j < width; j++) {
                if (row[j] == 1){
                    dp[j] = 0;
                }else if (j > 0){
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[width - 1];
    }
}
