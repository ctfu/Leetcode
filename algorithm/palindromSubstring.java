/* extend from each index(odd, even two situation)
time complexity: O(n^2) */
class Solution {
    private int res = 0;
    public int countSubstrings(String s) {
        if (s.length() == 0) {
            return 0;
        }
        for (int i = 0; i < s.length(); i++) {
            checkPalindrom(s, i, i);
            checkPalindrom(s, i, i + 1);
        }
        return res;
    }
    public void checkPalindrom(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            res++;
            left--;
            right++;
        }
    }
}
