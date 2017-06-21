/* method 1: recursion or loop */
public boolean isPowerOfThree(int n) {
    if(n>1)
        while(n%3==0) n /= 3;
    return n==1;
}

/* method 2: using log(n)/log(3) */
/* log(243) = 5.493061443340548    log(3) = 1.0986122886681098
   ==> log(243)/log(3) = 4.999999999999999

   log10(243) = 2.385606273598312    log10(3) = 0.47712125471966244
   ==> log10(243)/log10(3) = 5.0  */
public boolean isPowerOfThree(int n) {
                                            /* so we nned to round here */
    return n==0 ? false : n==Math.pow(3, Math.round(Math.log(n) / Math.log(3)));
}

/* Method 3: hardcoded solution */
public class Solution {
    public boolean isPowerOfThree(int n) {
        //3^19 is 1162261467, 3^20 is bigger than int
        return n > 0 && 1162261467 % n == 0;
    }
}
