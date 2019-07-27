/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.
Example 2:

Input: "()[]{}"
Output: true
*/
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else if(c == ')' && !stack.empty() && stack.peek() == '('){
                stack.pop();
            }else if(c == '}' && !stack.empty() && stack.peek() == '{'){
                stack.pop();
            }else if(c == ']' && !stack.empty() && stack.peek() == '['){
                stack.pop();
            }else{
                return false;
            }
        }
        return stack.empty(); /* last to check if the string is empty() */
    }
}
