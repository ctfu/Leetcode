/* similar to "Regular expression matching":
 * difference: '*' now matches zero ore more sequence chars, not rely on preceding char */
 /* o(n^2) dp solution */
public class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for(int j = 1; j <= p.length(); j++){
            if(p.charAt(j-1) == '*'){
                dp[0][j] = true;
            }else{
                break;
            }
        }
        /* starting from 1 to match dp, but actual char starts at 0, so using i-1 or j-1 for
         * current character checking */
        for(int i = 1; i <= s.length(); i++){
            for(int j = 1; j <= p.length(); j++){
                /* only two case in dp loop, current char at p is '*' or not */
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }
                /* only test when '*' represents empty string or represents more than 1 chars
                 * when "*" matches only one char, it is true, so it depends on last two cases */
                if(p.charAt(j-1) == '*'){
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}

/* two pointer solution: average: o(n), worse case o(p*s) such as: s=bbbbbbbb p=*b */
public class Solution {
    public boolean isMatch(String s, String p) {
        /* match used to indicate what index the '*' is currently matching to */
        int sIndex = 0, pIndex = 0, match = 0, starIndex = -1;
        while(sIndex < s.length()){
            if(pIndex < p.length() && (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '?')){
                sIndex++;
                pIndex++;
            }else if(pIndex < p.length() && p.charAt(pIndex) == '*'){
                starIndex = pIndex;
                match = sIndex;
                pIndex++;
            /* if pIndex > p.length || s.charAt(i) != p.charAt(i), repeatly go back to the char right
             * after last starIndex (essentially is increasing number of chars for star to matches)
             * the idea is to repeatly let star matches 1 to more chars to check match */
            }else if(starIndex != -1){
                pIndex = starIndex + 1;
                match++;
                sIndex = match;
            }else{
                return false;
            }
        }
        /* once s finished, anything left of p must be '*' to enable a match */
        while(pIndex < p.length() && p.charAt(pIndex) == '*'){
            pIndex++;
        }
        return pIndex == p.length();
    }
}
