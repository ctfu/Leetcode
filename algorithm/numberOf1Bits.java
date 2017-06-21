public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int one = 0;
        while(n != 0){ /* bit right shift unitl n = 0 */
            one += (n & 1);
            n = n >>> 1;    //using bit shifting
        }
        return one;
    }
    /* second way of counting 1 bits
    int count = 0;
    while(n != 0){
        count++;
        n = (n & (n-1)); // deal with last set bit 
    } */
}
