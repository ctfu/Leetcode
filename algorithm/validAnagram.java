/* count the frequency of chars in one string and see if other string satisfy it */
public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){ /* length first needs to be equal if anagram */
            return false;
        }else{
            int[] count = new int[26];
            for(char c : s.toCharArray()){
                count[c-'a']++;
            }
            for(char c: t.toCharArray()){
                if(--count[c-'a'] < 0){
                    return false;
                }
            }
            return true;
        }
    }
}
