public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int[] hash = new int[256];
        int begin = 0, end = 0;
        int counter = 0, res = 0;
        while(end < s.length()){
            if(hash[s.charAt(end++)]++ == 0){
                counter++;
            }
            while(counter > 2){
                if(hash[s.charAt(begin++)]-- == 1){
                    counter--;
                }
            }
            res = Math.max(res, end-begin);
        }
        return res;
    }
}
