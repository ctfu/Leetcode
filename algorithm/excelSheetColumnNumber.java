/* A = 1, Z = 26 */
public class Solution {
    public int titleToNumber(String s) {
        int result = 0;
        for(char c : s.toCharArray()){
            result = result * 26 + (c - 'A' + 1);/* A starts from 1 */
        }
        return result;
    }
}
