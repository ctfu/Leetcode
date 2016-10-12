public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int one = 0;
        while(n != 0){
            one += (n & 1);
            n = n >>> 1;    //using bit shifting
        }
        return one;
    }
}
