/* dp[i][j]: the matching status of i length of s string and j length of p string
 * dp[i][j] = 1. dp[i-1][j-1] if s.charAt(i) == p.charAt(j)
              2. dp[i-1][j-1] if p.charAt(j) == '.'
              3. if(p.charAt(j) == "*"):
                    1) dp[i][j-2] if p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.'
                    2) dp[i][j-2] if a* occurrs 0 times
                       dp[i][j-1] if a* occurs 1 times
                       dp[i-1][j] if a* occurs multiple times
 * Goal: dp[s.length()][p.length()] */
 /* Note: because the dp is starting at index 1, but s and p are starting at index 0,
  * so dp[i][j] is essentially above is essentially dp[i+1][j+1], dp[i][j-1] => dp[i+1][j-1] (j+2-1) */
public class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;    /* based case */
        /* initialize first row of pattern when s is empty, because even s is empty,
         * there still be cases that two string matching such as : s="", p= a*b* */
        for(int i = 0; i < p.length(); i++){
            if(p.charAt(i) == '*' && dp[0][i-1]){
                dp[0][i+1] = true;
            }
        }
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j < p.length(); j++){
                if(s.charAt(i) == p.charAt(j)){ /* if char at i,j are the same, matching status depends on previous i-1, j-1 status */
                    dp[i+1][j+1] = dp[i][j];
                }
                if(p.charAt(j) == '.'){ /* '.' mactches everything, dont need to consider cur char at index i */
                    dp[i+1][j+1] = dp[i][j];
                }
                if(p.charAt(j) == '*'){
                    if(p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.'){ /* 0 occurences of a* */
                        dp[i+1][j+1] = dp[i+1][j-1];
                    }else{ /* if preceding char matches: divided into three cases (a* occurs 0, 1 and multiple times) */
                        dp[i+1][j+1] = (dp[i+1][j-1] || dp[i+1][j] || dp[i][j+1]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}

/* Let s, and p starts at 1 to matches up dp */
public class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for(int i = 1; i <= p.length(); i++){
            if(p.charAt(i-1) == '*' && dp[0][i-2]){
                dp[0][i] = true;
            }
        }
        for(int i = 1; i <= s.length(); i++){
            for(int j = 1; j <= p.length(); j++){
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.'){
                    dp[i][j] = dp[i-1][j-1];
                }
                if(p.charAt(j-1) == '*'){
                    if(p.charAt(j-2) != s.charAt(i-1) && p.charAt(j-2) != '.'){
                        dp[i][j] = dp[i][j-2];  /* the only way to match is * appears zero times */
                    }else{
                        dp[i][j] = (dp[i][j-2] || dp[i][j-1] || dp[i-1][j]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
