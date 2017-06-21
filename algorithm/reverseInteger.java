public class Solution {
    public int reverse(int x) {
        int sign = x < 0 ? -1 : 1;
        int p = Math.abs(x);
        int res = 0;
        while(p != 0){
            //check integer reverse result overflow
            if(Integer.MAX_VALUE / 10 < res || (Integer.MAX_VALUE - p % 10) < res * 10){
                return 0;
            }
            res = res * 10 + p % 10;
            p /= 10;
        }
        return sign * res;
    }
}
