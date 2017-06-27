/* Apporach: KMP algorithm
 * time complexity: O(n), space complexity: O(n)
 */
public class Solution {
    public String shortestPalindrome(String s) {
        String str = s + "#" + new StringBuilder(s).reverse().toString();
        int[] lps = getLps(str);
        return new StringBuilder(s.substring(lps[str.length() - 1])).reverse().toString() + s;
    }

    public int[] getLps(String s) {
        int[] lps = new int[s.length()];
        int j = 0, i = 1;
        lps[0] = 0;
        while (i < lps.length) {
            if (s.charAt(j) == s.charAt(i)) {
                j++;
                lps[i] = j;
                i++;
            } else {
                if (j != 0) {
                    j = lps[j-1];
                } else {
                    lps[i] = j;
                    i++;
                }
            }
        }
        return lps;
    }
}
