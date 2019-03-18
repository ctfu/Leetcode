Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every character in T appears no less than k times.

Example 1:

Input:
s = "aaabb", k = 3

Output:
3

The longest substring is "aaa", as 'a' is repeated 3 times.
Example 2:

Input:
s = "ababbc", k = 2

Output:
5

The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
--------------------------------------------------------------------------------
class Solution {
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] hash = new int[26];
        int begin = 0, end = 0, result = 0;
        boolean flag = true;

        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (hash[s.charAt(i) - 'a'] > 0 && hash[s.charAt(i) - 'a'] < k) {
                flag = false;
            }
        }
        if (flag == true) return s.length();

        while (end < s.length()) {
            if (hash[s.charAt(end) - 'a'] < k) {
                result = Math.max(result, longestSubstring(s.substring(begin, end), k));
                begin = end + 1;
            }
            end++;
        }
        // this is needed becasue the begin pointer doesnot reach the end of the
        // string whiel end pointer does
        result = Math.max(result, longestSubstring(s.substring(begin), k));
        return result;
    }
}
