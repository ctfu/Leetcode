public class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        /* handle corner cases, when dividing by a very large number, res ~= 0, except
        x is 1 or -1, then the result should be 1 */
        if(n == Integer.MIN_VALUE && x != 1.0 && x != -1.0 ){
            return 0;
        }
        if(n < 0){  /* if the pow is negative */
            n = -n;
            x = 1/x;
        }
        return (n % 2 == 0) ? myPow(x*x, n/2) : x * myPow(x*x, n/2);
    }
}
