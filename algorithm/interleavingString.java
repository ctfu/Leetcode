/* dp[i][j]: s3 can be formed by interleaving string s1 and s2 with length i and j
 * dp[i][j] = 1. i == 0 && j == 0
              2. i == 0
              3. j == 0
              4. dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1) || dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1)
* Goal: dp[s1.length()][s2.length()]
* Note: in the table, the string starts at index 1, but s1, s2, and s3 starts at 0, so need to substract 1
* i-1: current char index at s1, j-1: currnet char index at s2, i+j-1: current char index at s3 */
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length() != s1.length() + s2.length()) return false;
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        for(int i = 0; i <= s1.length(); i++){
            for(int j = 0; j <= s2.length(); j++){
                if(i == 0 && j == 0){
                    dp[i][j] = true;
                }else if(i == 0){
                    dp[i][j] = dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1);
                }else if(j == 0){
                    dp[i][j] = dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1);
                }else{
                    dp[i][j] = dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1) ||
                                dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
