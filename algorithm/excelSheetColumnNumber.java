public class Solution {
    public int titleToNumber(String s) {
        int result = 0;
        for(char c : s.toCharArray()){
            result = result * 26 + (c - 'A' + 1);
        }
        return result;
    }
}
