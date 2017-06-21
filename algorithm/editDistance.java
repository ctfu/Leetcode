/* dp[i][j]: indicates the minimum steps to convert a string a with length i to string b with length j */
public class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];

        for(int i = 0; i <= word1.length(); i++){   /* word1 is empty */
            dp[i][0] = i;
        }
        for(int j = 0; j <= word2.length(); j++){   /* word2 is empty */
            dp[0][j] = j;
        }
        for(int i = 1; i <= word1.length(); i++){
            for(int j = 1; j <= word2.length(); j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = dp[i-1][j-1] + 1; /* replace operation */
                }
                /* dp[i][j] = dp[i-1][j] + 1 : remove operation
                 * dp[i][j] = dp[i][j-1] + 1 : insert operation (insert 1 to word1 is the same as remove 1 from word2) */
                dp[i][j] = Math.min(dp[i][j], Math.min(dp[i-1][j]+1, dp[i][j-1]+1));
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
