Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.

Example 1:

Input: "eceba"
Output: 3
Explanation: t is "ece" which its length is 3.
Example 2:

Input: "ccaabbb"
Output: 5
Explanation: t is "aabbb" which its length is 5.
------------------------------------------------------------------
public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int[] hash = new int[256];
        int begin = 0, end = 0;
        int counter = 0, res = 0;
        while(end < s.length()){
            if(hash[s.charAt(end++)]++ == 0){
                counter++;
            }
            while(counter > 2){
                if(hash[s.charAt(begin++)]-- == 1){ //getting out of the condition
                    counter--;
                }
            }
            res = Math.max(res, end-begin);
        }
        return res;
    }
}
