/* dp[i][j] - the longest palindromic subsequence within index i, j
 * dp[i][j] = dp[i+1][j-1] + 2 if (s.charAt(i) == s.charAt(j)
 *          = Math.max(dp[i+1][j], dp[i][j-1]) otherwise
 * default case: dp[i][i] = 1 always */
public class Solution {
    public int longestPalindromeSubseq(String s) {
        if(s.length() < 2) return s.length();
        int[][] dp = new int[s.length()][s.length()];
        for(int i = s.length()-1; i >= 0; i--){
            dp[i][i] = 1; /* set default case */
            for(int j = i+1; j < s.length(); j++){
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1] + 2;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
                }
            }
        }
        return dp[0][s.length()-1];
    }
}
