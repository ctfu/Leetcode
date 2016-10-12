public class Solution {
    public int getSum(int a, int b) {
      // a ^ b is result without carry
      //a & b is carry result (which needs to be shifted one left)
      //if without carry, a ^ b is the binary addition
      return b ==0 ? a : getSum(a^b, (a&b)<<1);
    }
}
