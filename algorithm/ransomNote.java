public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];
        for(char c : magazine.toCharArray()){
            count[c-'a']++;     //count number of letter from magazine
        }
        for(char c : ransomNote.toCharArray()){
            if(--count[c-'a'] < 0) return false;    //substract ransomNote letter from magazine
        }
        return true;
    }
}
