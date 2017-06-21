/* Approach: Divide and conquer + HashTable -- o(nlogn): divide conquer o(logn), o(n) to find the char less than K repeates 
 * 1. Divide s into two parts based on the character that has less k repeates
 * 2. Recursively calculate the substring length for each part */
public class Solution {
    public int longestSubstring(String s, int k) {
        if(s == null || s.length() == 0) return 0;
        return findSubstring(s, k, 0, s.length());
    }
    public int findSubstring(String s, int k, int begin, int end){
        if(end - begin < k) return 0;
        int[] hash = new int[26];
        /* counte the character occurence within begin and end interval */
        for(int i = begin; i < end; i++){
            hash[s.charAt(i)-'a']++;
        }
        for(int i = 0; i < 26; i++){
            if(hash[i] > 0 && hash[i] < k){
                for(int j = begin; j < end; j++){
                    if(s.charAt(j) == i+'a'){
                        int leftLen = findSubstring(s, k, begin, j);
                        int rightLen = findSubstring(s, k, j+1, end);/* j is repeats less than k, so j+1 */
                        return Math.max(leftLen, rightLen);
                    }
                }
            }
        }
        return end - begin;
    }
}
