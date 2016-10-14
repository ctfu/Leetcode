public class Solution {
    //solve the problem using fibonacci concpet
    public int climbStairs(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;

        int f1 = 1;
        int f2 = 2;
        int f3 = 0;
        for(int i = 3; i <= n; i++){
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }
}
