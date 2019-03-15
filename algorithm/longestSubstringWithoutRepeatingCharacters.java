/*
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/             
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int[] hash = new int[256];
        int begin = 0, end = 0, counter = 0;
        int longest = 0;
        while(end < s.length()){
            if(hash[s.charAt(end++)]++ > 0){
                counter++;
            }
            while(counter > 0){
                if(hash[s.charAt(begin++)]-- > 1){
                    counter--;
                }
            }
            longest = Math.max(longest, end - begin);
        }
        return longest;
    }
}
