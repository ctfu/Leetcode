/* String Palindrom Problem:
 * 1. Given a string, determin palindrom (two pointer)
 * 2. Given a string, can the permutation form a palindrom (hashtable, count odd, even chars frequency)
 * 3. Given a string, calculate the length of longest palindrom possible (hashtable, below)
 * 4. Given a string, find the longest palindrom substring */
public class Solution {
    public int longestPalindrome(String s) {
        boolean[] seen = new boolean[128]; /* all false */
        int len = 0;
        for(char c : s.toCharArray()){
            seen[c] = !seen[c]; /* flip to true */
            if(!seen[c]) len += 2; /* seen[c] becomes false when seens twice*/
        }
        if(len < s.length()) len++; /* if unique char is available */
        return len;
    }
}
