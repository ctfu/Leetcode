/* Approach: recursive, by manipulating a global index
* time complexity: O(n), space complexity: O(k), k is number of nested tenary expressions
*/
public class Solution {
    private int index = 0;
    public String parseTernary(String expression) {
        return parser(expression);
    }

    public String parser(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(index));
        if (index + 1 == s.length() || s.charAt(index + 1) == ':') {
            index += 2;
            return sb.toString();
        }
        index += 2;
        String first = parser(s), second = parser(s);
        return sb.toString().equals("T") ? first : second;
    }
}

/* second approach: push each char to the stack from tail to begin, since question restrick only single digit
* for each number */
