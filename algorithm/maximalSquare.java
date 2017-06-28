/* Approach: Dynamic programming
 * dp[i][j]: stores the side length of the maximum square correspoinding to the bottom right cell index
 * dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1
 * time complexity O(mn), space complexity O(mn)
 * Note: can reduce the space complexity to O(n), by storing dp[i][j-1] as a previous temp value
 */
public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int rows = matrix.length, cols = matrix[0].length;
        int[][] dp = new int[rows+1][cols+1];
        int maxSqLen = 0;
        for (int i = 1; i < rows + 1; i++) {
            for (int j = 1; j < cols + 1; j++) {
                if (matrix[i-1][j-1] == '1') {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                    maxSqLen = Math.max(maxSqLen, dp[i][j]);
                }
            }
        }
        return maxSqLen * maxSqLen;
    }
}
