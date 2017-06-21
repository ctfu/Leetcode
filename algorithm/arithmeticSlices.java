public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int slices = 0;
        int cur = 0;
        for(int i = 2; i < A.length; i++){
            if((A[i]-A[i-1]) == (A[i-1]-A[i-2])){
                cur++;
                slices += cur;
            }else{
                cur = 0;
            }
        }

        return slices;
    }
}

/* But if (A[i]-A[i-1] == A[i-1]-A[i-2]) introduces an integer overflow bug.

If the input is [Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE - 1], it returns 1, but it should be 0.
when overflow, the return value is -1
Correction: */

if((long)A[i]-A[i-1] == (long)A[i-1]-A[i-2]){
    cur++;
    slices += cur;
}else{
    cur = 0;
}
