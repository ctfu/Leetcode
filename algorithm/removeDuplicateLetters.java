/* greedy recursive approach:
 * each time select the smallest char from left, remove all chars before it and remove all same chars after it.
 * time complexity: O(n), at most called 26 times, space complexity: O(n)
 */
public class Solution {
    public String removeDuplicateLetters(String s) {
        if (s.length() <= 1) {
            return s;
        }
        int[] hash = new int[26];
        for (char c : s.toCharArray()) {
            hash[c - 'a']++;
        }
        int pos = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(pos)) {
                pos = i;
            }
            if (--hash[s.charAt(i) - 'a'] == 0) {
                break;
            }
        }
        return s.charAt(pos) + removeDuplicateLetters(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
    }
}
