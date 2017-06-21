    public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for(int i = 0; i < 32; i++){
            /* we can't use while(n != 0) here because we ned to left shit res 31 times */
            result <<= 1;
            res += (n&1);
            n >>= 1;
        }
        return result;
    }
}
