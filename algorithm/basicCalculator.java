/* 1. initial setup: temp(tempory calculation result) sign(positivity of calculation), res(final result)
 * 2. if see "+", store result, reset temp and sign (1)
 * 3. if see "-", store result, rest temp and sign(-1)
   4. if see "(", push resut and sign to stack
   5. if see ")", store temp result, pop sign, pop result, and store result */
public class Solution {
    public int calculate(String s) {
       Stack<Integer> stack = new Stack<>();
       int res = 0;
       int number = 0;
       int sign = 1;
       for(int i = 0; i < s.length(); i++){
           char c = s.charAt(i);
           if(Character.isDigit(c)){
               number = number * 10 + (c - '0'); /* if number has more than one digit */
           }else if(c == '+'){
               res += sign * number;
               number = 0;
               sign = 1;
           }else if(c == '-'){
               res += sign * number;
               number = 0;
               sign = -1;
           }else if(c == '('){
               stack.push(res);
               stack.push(sign);
               res = 0;         /* here is res set to 0 */
               sign = 1;
           }else if(c == ')'){
               res += sign * number;
               number = 0;
               res *= stack.pop(); /* pop the sign */
               res += stack.pop(); /* pop the temp result */
           }
       }
       return number == 0 ? res : (res += sign * number);
    }
}
