/* dp[n]: number of unique BSTs with number length n (n numbers)
 * F(i, n): number of unique BSTs rooted at number i, where, 1<=i<=n
 * F(i, n) = dp[i-1]*dp[n-i]
 * Interate through every number 1<=i<=n as root:
 * dp[n] = dp[0]*dp[n-1] + dp[1]*dp[n-2] + ... + dp[n-1]*dp[0] */
public class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;  /* when tree has no length (empty) */
        dp[1] = 1;  /* when tree has only one length (root) */
        for(int i = 2; i <= n; i++){    /* for each len */
            for(int j = 1; j <= i; j++){    /* iterate through each number from [1,i]*/
                int Fji = dp[j-1] * dp[i-j];
                dp[i] += Fji;
            }
        }
        return dp[n];
    }
}
