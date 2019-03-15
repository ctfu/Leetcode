Given a string, find the length of the longest substring T that contains at most k distinct characters.

Example 1:

Input: s = "eceba", k = 2
Output: 3
Explanation: T is "ece" which its length is 3.
Example 2:

Input: s = "aa", k = 1
Output: 2
Explanation: T is "aa" which its length is 2.
-------------------------------------------------------------------
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
