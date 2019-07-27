/* implement a calculator with following signs:
 * 1. if see "+", store result, reset temp and sign (1)
 * 2. if see "-", store result, rest temp and sign(-1)
 * 3. if see "(", push resut and sign to stack
 * 4. if see ")", store temp result, pop sign, pop result, and store result */
public class Solution {
    public int calculate(String s) {
        int total = 0;
        int accumulate = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                accumulate = accumulate * 10 + (c - '0');
            } else if (c == '+') {
                total += sign * accumulate;
                accumulate = 0;
                sign = 1;
            } else if (c == '-') {
                total += sign * accumulate;
                accumulate = 0;
                sign = -1;
            } else if (c == '(') {
                stack.push(sign);
                stack.push(total);
                total = 0;
                accumulate = 0;
                sign = 1;
            } else if (c == ')') {
                total += sign * accumulate;
                int lastTotal = stack.pop();
                sign = stack.pop();
                total = lastTotal + sign * total;
                accumulate = 0;
                sign = 1;
            }
        }
        // to get the last accumulate at the end
        return accumulate == 0 ? total : (total += sign * accumulate);
    }
}
