public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int[] hash = new int[256];
        int begin = 0, end = 0, counter = 0;
        int longest = 0;
        while(end < s.length()){
            if(hash[s.charAt(end++)]++ > 0){
                counter++;
            }
            while(counter > 0){
                if(hash[s.charAt(begin++)]-- > 1){
                    counter--;
                }
            }
            longest = Math.max(longest, end - begin);
        }
        return longest;
    }
}
