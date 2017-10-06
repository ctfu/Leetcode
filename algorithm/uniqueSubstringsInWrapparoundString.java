class Solution {
    public int findSubstringInWraproundString(String p) {
        int[] dp = new int[26];
        int strSize = 0;
        for (int i = 0; i < p.length(); i++) {
            if (i > 0 && (p.charAt(i) - p.charAt(i - 1) == 1 || p.charAt(i-1) - p.charAt(i) == 25)) {
                strSize++;
            } else {
                strSize = 1;
            }
            int key = p.charAt(i) - 'a';
            dp[key] = Math.max(dp[key], strSize);
        }
        int res = 0;
        for (int n : dp) {
            res += n;
        }
        return res;
    }
}
