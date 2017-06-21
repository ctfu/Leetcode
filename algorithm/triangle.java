/* Bottom up dp approach    
 * dp[i][j]: indicates the mim path sum to bottom at row i, starting from num in index j
 * dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1]) + triangle.get(i).get(j) (only move down to adjacent number)
 * Goal: dp[0][0] */
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();
        int[][] dp = new int[rows][rows];
        /* the advantage of bottom up here is that, each num in the last row is
         * the minimum path sum itself */
        for(int j = 0; j < triangle.get(rows-1).size(); j++){
            dp[rows-1][j] = triangle.get(rows-1).get(j);
        }
        for(int i = rows-2; i >= 0; i--){
            for(int j = 0; j < triangle.get(i).size(); j++){
                dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }
}

/* reduce to o(n) extra space */
/* dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1]) + triangle.get(i).get(j)
 * i+1 level is useless after level i is calculated, so get rid of it:
 * dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j) */
 public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();
        int[]dp = new int[triangle.get(rows-1).size()]; /* intialize to the last row of the triangle */
        for(int j = 0; j < triangle.get(rows-1).size(); j++){ /* base case is the last row */
            dp[j] = triangle.get(rows-1).get(j);
        }
        /* repeatly update the index on the same dp over each row */
        for(int i = rows-2; i >= 0; i--){
            for(int j = 0; j < triangle.get(i).size(); j++){
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
