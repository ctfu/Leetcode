/* DP approach
 * Dp[i] indicates word of length i can be break into a sequence of words
 * If string s of length n can be break into a sequence of words,
 * There must exist a word s1 of length k in[0,n] that is breakable &&
 * s.substring(k, n) is a valid word in the dictionary */
 
 /* optimal substructure: dp[i] = dp[j]{0<=j<i} && dict.contains(s.substring(j, i)) */
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;/* zero length word is always true */
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && dict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
