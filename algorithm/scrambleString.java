/* Recursive: time complexity T(n) = n * T(n-1) ~ O(n!)
/* Defition of scramble string: exact same chars with same frequency */
public class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1.equals(s2)) return true;
        if(s1.length() != s2.length()) return false;
        int[] hash = new int[26];
        for(int i = 0; i < s1.length(); i++){
            hash[s1.charAt(i)-'a']++;
            hash[s2.charAt(i)-'a']--;
        }
        for(int i = 0; i < 26; i++){
            if(hash[i] < 0){
                return false;
            }
        }
        for(int i = 1; i < s1.length(); i++){
            if(isScramble(s1.substring(0, i), s2.substring(0, i)) &&
                                        isScramble(s1.substring(i), s2.substring(i))){
                return true;
            }
            /* the first two child node could be swap, so the string could be in a reverse order */
            if(isScramble(s1.substring(0, i), s2.substring(s2.length()-i)) &&
                                        isScramble(s1.substring(i), s2.substring(0, s2.length()-i))){
                return true;
            }
        }
        return false;
    }
}
