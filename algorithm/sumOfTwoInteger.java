Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

Example 1:

Input: a = 1, b = 2
Output: 3

/* a ^ b is result without carry
 * a & b is carry result (which needs to be shifted one left)
 * if without carry, a ^ b is the binary addition */
 
public class Solution {
    public int getSum(int a, int b) {
      return b ==0 ? a : getSum(a^b, (a&b)<<1);
    }
}
