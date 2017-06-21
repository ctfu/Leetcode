/* dp[i]: the minimum cut to partition the string from index i to the end
 * Using two pointers x, y to expand from each index to form palindrom, starting from the end
 * dp[x] = Math.min(dp[x], dp[y+1]+1) if substring from x to y is a palindrom
 * Goal: dp[0] */
public class Solution {
    public int minCut(String s) {
        if(s == null || s.length() == 0) return 0;
        int[] dp = new int[s.length()+1];
        for(int i = 0; i < s.length(); i++) dp[i] = Integer.MAX_VALUE;
        /* the reason why we start from end, we can initialize dp[s.length()-1] = -1, so that it satisfy
         * the minimum cut from last index to the end is 0, if start from beging, we dont have a way to initialize
         * dp[-1] = -1 */
        dp[s.length()] = -1;

        for(int i = s.length()-1; i >= 0; i--){
            for(int x = i, y = i; x >= 0 && y < s.length() && s.charAt(x) == s.charAt(y); x--, y++){
                dp[x] = Math.min(dp[x], dp[y+1]+1);
            }
            for(int x = i, y = i+1; x >= 0 && y < s.length() && s.charAt(x) == s.charAt(y); x--, y++){
                dp[x] = Math.min(dp[x], dp[y+1]+1);
            }
        }
        return dp[0];
    }
}
