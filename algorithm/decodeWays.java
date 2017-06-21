/* dp[i]: indicates the # of decode ways for substring starting from index i to the end
 * dp[i] = dp[i+1] + dp[i+2] if(Integer.parseInt(s.substring(i, i+2) <= 26))
 * The # of decode ways staring with char at index (i+1) + # of decode ways substring(i, i+2) bundle together
 * dp[i] = dp[i+1], if substring(i, i+2) is not valid */
 /* The reason why we are dp from the end is because at index i, we also want to know if i and i+1 can be used
  * together as one decode string */
public class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) return 0;
        int n = s.length();
        int[] dp = new int[n+1];
        dp[n] = 1;  /* initialize n */
        dp[n-1] = s.charAt(n-1) == '0' ? 0 : 1; /* if last char is '0', no way to use it for decode */
        for(int i = n-2; i >= 0; i--){
            if(s.charAt(i) == '0') continue;    /* if '0', only way to use it to associate it with char at i-1 */
            if(Integer.parseInt(s.substring(i, i+2)) <= 26){
                /*dp[i+2] indiciate the ways when substring(i,i+2) bundle together, so needs to plus # of ways dp[i+2] */
                dp[i] = dp[i+1] + dp[i+2];
            }else{
                dp[i] = dp[i+1]; /* otherwise will just be the same by only adding one more char */
            }
        }
        return dp[0];
    }
}
