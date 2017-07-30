/* DP
* dp[i][j] - the minimum steps to search key[i] when ring[j] is at the 12:00 clock direction without press button
*/
public int findRotateSteps(String ring, String key) {
    int n = ring.length();
    int m = key.length();
    int[][] dp = new int[m + 1][n];

    for (int i = m - 1; i >= 0; i--) {
        for (int j = 0; j < n; j++) {   //brute forece to consider each j is at 12:00
            dp[i][j] = Integer.MAX_VALUE;
            for (int k = 0; k < n; k++) {   // search forward for in the ring based on ring[j]
                if (ring.charAt(k) == key.charAt(i)) {
                    int diff = Math.abs(j - k);    // calculate the steps for searching key[i]
                    int step = Math.min(diff, n - diff); // n - diff is steps for backward searching
                    // find the min step for searching key[i], current searching ends at ring[k] so key[i + 1] starts
                    // at dp[i + 1[k]
                    dp[i][j] = Math.min(dp[i][j], step + dp[i + 1][k]);
                }
            }
        }
    }

    return dp[0][0] + m;
}

/* DFS
* recursivly searching for each key[i] starting at index 0 in the ring
* at each searching stage, two problems need to solve:
* 1. steps for searching forward: 1 + forwardPos + dfs for next stage
* 2. steps for searching backward: 1 + ring.length() - backwardPos + def for next stage
* dfs(ring.substring(endPos) + ring.substring(0, endPos), key, index + 1) prepare for the next stage searching
* ring.substring(endingPos) + ring.substring(0, endPos) prepares the new string for next stage searching, becase 
* the current seaching ends at the endingPos */
