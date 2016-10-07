public class Solution {
    public int firstUniqChar(String s) {
       int[] count = new int[26];
       int index = 0;
       for(char c : s.toCharArray()){
           count[c-'a']++;
       }
       for(char c : s.toCharArray()){
           if(count[c-'a'] == 1){
               return index;
           }
           index++;
       }
       return -1;
    }
}
