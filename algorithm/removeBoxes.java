/* DP
* dp[i][j][k] - maximum points from i to j with k same color boxes attached after index i
*/
public class Solution {
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] dp = new int[n][n][n];
        return remove(boxes, 0, n - 1, 0, dp);// k starts from 0
    }
    public int remove(int[] boxes, int i, int j, int k, int[][][] dp) {
        if (i > j) return 0;
        if (dp[i][j][k] > 0) return dp[i][j][k]; // prevent duplicate calculation
        int res = (k + 1) * (k + 1) + remove(boxes, i + 1, j, 0, dp); // assume only first box has same color
        for (int m = i + 1; m <= j; m++) { // start searching from second box for the sam color
            if (boxes[i] == boxes[m]) {
                res = Math.max(res, remove(boxes, i + 1, m - 1, 0, dp) + remove(boxes, m, j, k + 1, dp));
            }
        }
        dp[i][j][k] = res;
        return res;
    }
}
