/* DP
* Because first number is always smaller thant the second number
* 1. sort the pairs
* 2. dp[i] -> indicates the longest pair chain till ith pair
*/
public class Solution {
    public int findLongestChain(int[][] pairs) {
        if (pairs.length == 0 || pairs[0].length == 0) {
            return 0;
        }
        Arrays.sort(pairs, new Comparator<int[]>() {
           @Override
            public int compare(int[] p1, int[] p2) {
                return p1[0] - p2[0];
            }
        });
        int[] dp = new int[pairs.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = Math.max(dp[i], pairs[i][0] > pairs[j][1] ? dp[j] + 1 : dp[j]);
            }
        }
        return dp[dp.length - 1];
    }
}
