/* Approach: stack
 * time complexity: O(n), space complexity: O(n)
 */
public class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int tempRes = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                tempRes = tempRes * 10 + s.charAt(i) - '0';
            }
            // here not use else, if reach last number, need to perform calculation for previous sign 
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == s.length() - 1) {
                if (sign == '+') {
                    stack.push(tempRes);
                } else if (sign == '-') {
                    stack.push(-tempRes);
                } else if (sign == '*') {
                    stack.push(stack.pop() * tempRes);
                } else if (sign == '/') {
                    stack.push(stack.pop() / tempRes);
                }
                tempRes = 0;
                sign = s.charAt(i);
            }
        }
        int res = 0;
        for (int num : stack) {
            res += num;
        }
        return res;
    }
}
