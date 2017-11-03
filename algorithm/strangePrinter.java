/*
s:     abc .....   d
index: i  ..k.     j
f(i, j) minimum steps to print s
f(i, j): worse case j - i + 1
f(i, j) = Min(f(i, k) + f(k + 1, j) - 1 if (s[k] == s[j]) {i <= k < j})
aba

*/
class Solution {
    public int strangePrinter(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        for (int j = 1; j < len; j++) {  // j distance between start and end of s
            for (int i = 0; i + j < len; i++) {
                dp[i][i + j] = j + 1; // worse case i + j - i + 1
                for (int k = i; k < i + j; k++) {
                    int total = dp[i][k] + dp[k + 1][i + j];
                    if (s.charAt(k) == s.charAt(i + j)) {
                        total--;
                    }
                    dp[i][i + j] = Math.min(dp[i][i + j], total);
                }
            }
        }
        return dp[0][len - 1];
    }
}
