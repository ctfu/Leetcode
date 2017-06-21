/* Stack stores only the unmatched parenthesis char index, anything in between are valid match parenthesis */
public class Solution {
    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(i);  /* push the index */
            }else if(s.charAt(i) == ')'){
                if(!stack.empty() && s.charAt(stack.peek()) == '('){/* if found a match, pop the stack */
                    stack.pop();
                }else{
                    stack.push(i);  /* Otherwise, push the index */
                }
            }
        }
        if(stack.empty()){  /* if stack is empty, whole string is valid */
            return s.length();
        }
        /* otherwise, search for valid string length in between invalid parenthesis */
        int max = 0, begin = 0, end = s.length();
        while(!stack.empty()){
            begin = stack.pop();
            int len = end-begin-1;
            max = Math.max(max, len);
            end = begin;
        }
        max = Math.max(max, end);   /* cases such as "())""
        return max;
    }
}
