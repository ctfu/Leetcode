/* time complexity: O(n);
* space complexity: O(2n);
*/
class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(); // store the reverse result
        StringBuilder temp = new StringBuilder(); // store each word
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                if (temp.length() != 0) {
                    sb.append(temp.reverse().toString());
                    temp.setLength(0);
                }
                sb.append(c);
            } else {
                temp.append(c);
            }
        }
        if (temp.length() != 0) {
            sb.append(temp.reverse().toString());
        }
        return sb.toString();
    }
}
