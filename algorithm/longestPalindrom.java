public class Solution {
    public int longestPalindrome(String s) {
        boolean[] seen = new boolean[128];
        int len = 0;
        for(char c : s.toCharArray()){
            seen[c] = !seen[c];
            if(!seen[c]) len += 2;      //false when letter has ben seen twice
        }
        if(len < s.length()) len++;
        return len;
    }
}
