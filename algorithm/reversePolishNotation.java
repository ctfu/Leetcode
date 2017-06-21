/* whenever see operator, pop two numbers out from stack and calculate
 * push res back */
public class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens.length == 0) return 0;
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        int second, first;
        for(int i = 0; i < tokens.length; i++){
            String s = tokens[i];
            if(s.equals("+")){
                second = stack.pop(); /* first pop is the second number */
                first = stack.pop();
                res = first + second;  /* it is important first op second */
                stack.push(res);
            }else if(s.equals("-")){
                second = stack.pop();
                first = stack.pop();
                res = first - second;
                stack.push(res);
            }else if(s.equals("*")){
                second = stack.pop();
                first = stack.pop();
                res = first * second;
                stack.push(res);
            }else if(s.equals("/")){
                second = stack.pop();
                first = stack.pop();
                res = first / second;
                stack.push(res);
            }else{
                stack.push(Integer.parseInt(s));/* push the pased value */
            }
        }
        return stack.pop();
    }
}
