//analysis
/*
step1 :
F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1]
F(k-1) = 0 * Bk-1[0] + 1 * Bk-1[1] + ... + (n-1) * Bk-1[n-1]
       = 0 * Bk[1] + 1 * Bk[2] + ... + (n-2) * Bk[n-1] + (n-1) * Bk[0]

step 2:
F(k) - F(k-1) = Bk[1] + Bk[2] + ... + Bk[n-1] + (1-n)Bk[0]
              = (Bk[0] + ... + Bk[n-1]) - nBk[0]
              = sum - nBk[0]

step 3:
F(k) = F(k-1) + sum - nBk[0] (n is array length, BK[0] is each end value)

The value of Bk[0]:
k = 0; Bk[0] = A[0]
k = 1; Bk[0] = A[length -1]
k = 2; Bk[0] = A[length -2]
...
*/

public class Solution {
    public int maxRotateFunction(int[] A) {
        if(A.length == 0) return 0;

        int len = A.length;
        int sum = 0;
        int Fnt = 0;
        for(int i = 0; i < len; i++){
            Fnt += i * A[i];    /*  k = 0 rotation */
            sum += A[i];        /* the sum as explained above */
        }
        int max = Fnt;
        /* k = (1~n-1) rotation: sum - Bk[0], Bk[0] is each end value at each rotation */
        for(int i = 1; i < len; i++){
            Fnt = Fnt + sum - len*A[len-i];
            max = Math.max(max, Fnt);
        }
        return max;
    }
}
