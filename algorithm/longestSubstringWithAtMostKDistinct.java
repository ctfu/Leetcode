/* similar to longestSubstringWithAtMost2Distict problem */
public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s == null || s.length() == 0) return 0;
        int[] hash = new int[256];
        int begin = 0, end = 0;
        int count = 0, len = 0; /* counter to count the uniqueness */
        while(end < s.length()){
            if(hash[s.charAt(end++)]++ == 0){
                count++;
            }
            while(count > k){
                if(hash[s.charAt(begin++)]-- == 1){
                    count--;
                }
            }
            len = Math.max(len, end-begin);
        }
        return len;
    }
}
