/* expanding around the center */
public class Solution {
    int start, maxLen;
    public String longestPalindrome(String s) {
        if(s.length() < 2) return s;
        for(int i = 0; i < s.length()-1; i++){
            expandPalindrom(s, i, i); /* assume the string has odd number of chars */
            expandPalindrom(s, i, i+1); /* assume the string has even number of chars */
        }
        return s.substring(start, start+maxLen);
    }
    private void expandPalindrom(String s, int i, int j){
        while(i >=0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }
        if(maxLen < j-i-1){
            start = i + 1;
            maxLen = j-i-1;
        }
    }
}

/* get rid of the global variable */
public class Solution {
    public String longestPalindrome(String s) {
        if(s.length() < 2) return s;
        int start = 0, end = 0; /* start, end index of found palindrom */
        /* expanding around the center, try every center */
        for(int i = 0; i < s.length()-1; i++){
            int len1 = expandPalindrom(s, i, i); /* if the string has odd number of chars */
            int len2 = expandPalindrom(s, i, i+1); /* if the string has even number of chars */
            int len = Math.max(len1, len2);
            if(len > end - start + 1){
                start = i - (len-1)/2; /* i is the center index, i-(len-1)/2 = start index */
                end = i + len/2; /* center + half of the lenth to get end index */
            }
        }
        return s.substring(start, end+1);
    }
    private int expandPalindrom(String s, int i, int j){
        while(i >=0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }
        /* because the i & j has incremented, that's why needs to j-i-1*/
        return j - i - 1;
    }
}
