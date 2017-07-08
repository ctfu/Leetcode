/* Approach: repeat stack, stringBuilder stack
* stringBuilder.append(anotherStringBuilder): append the str representation of anotherStringBuilder, similar to append sb.toString
* time complexity: O(n)
*/
public class Solution {
    public String decodeString(String s) {
        char[] str = s.toCharArray();
        Stack<Integer> repeatStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int repeat = 0;
        for (char c : str) {
            if (Character.isDigit(c)) {
                repeat = repeat * 10 + (c - '0');
            } else if (c == '[') {
                repeatStack.push(repeat);
                stringStack.push(sb);
                repeat = 0;
                sb = new StringBuilder();
            } else if (c == ']') {
                StringBuilder temp = sb;
                sb = stringStack.pop();
                int rp = repeatStack.pop();
                for (int i = rp; i > 0; i--) {
                    sb.append(temp);
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
