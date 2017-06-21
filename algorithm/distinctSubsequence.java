/* dp[i][j]: number of times s with char length j, consists of  t with char length i
 * dp[i][j] = dp[i-1][j-1] + dp[i][j-1] if t.charAt(i-1) == s.charAt(j-1)
            = dp[i][j-1] else */
public class Solution {
    public int numDistinct(String s, String t) {
        if(s == null || s.length() == 0) return 0;
        int[][] dp = new int[t.length()+1][s.length()+1];

        for(int i = 0; i <= t.length(); i++){
            for(int j = 0; j <= s.length(); j++){
                if(i == 0){
                    dp[i][j] = 1;   /* empty string t is substring for any length of s */
                }else if(j == 0){
                    dp[i][j] = 0;   /* empty string s contains non of t */
                }else if(t.charAt(i-1) == s.charAt(j-1)){   /* if current char match */
                    dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
                }else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[t.length()][s.length()];
    }
}
