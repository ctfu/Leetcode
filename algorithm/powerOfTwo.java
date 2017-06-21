public class Solution {
    public boolean isPowerOfTwo(int n) {
       if(n == 0) return false;
       /* recursively divide by 2 */
       while(n % 2 == 0){
           n /= 2;
       }
       return n==1;
    }
}
