/* Remove k digits of a string representation of a number, so that the new number is the smallest possible
* maintain a monotonmic increasing stack
* whenever the current number is smaller than the previous num, the previous num has a chance to form bigger number,
* so we use pop it out */
public class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            if (stack.empty() || num.charAt(i) >= stack.peek()) {
                stack.push(num.charAt(i));
            } else {
                while (!stack.empty() && num.charAt(i) < stack.peek() && k > 0) {
                    stack.pop();
                    k--;
                }
                stack.push(num.charAt(i));
            }
        }
        /* if the number sequence is increasing, then we should remove it from the end */
        while (k-- > 0) {
            stack.pop();
        }
        /* find out the first non-leading zero number sequence */
        StringBuilder sb = new StringBuilder();
        boolean valid = false;
        for (char c : stack) {
            if (c != '0') {
                valid = true;
            }
            if (valid) {
                sb.append(c);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
