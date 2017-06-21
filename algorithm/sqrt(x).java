/* Binary search a number's square */
public class Solution {
    public int mySqrt(int x) {
        if(x <= 1) return x;
        Long begin = (long)0;/* cast into Long(which as intValue() function), in case later square oveflow */
        Long end = (long)x / 2 + 1; /* reason "+1", becasue we want (begin < end) */
        while(begin < end){
            Long mid = begin + (end-begin)/2;
            if(mid * mid == x){ /* check if mid square equals x */
                return mid.intValue(); /*cast back to int value */
            }else if(mid * mid > x){
                end = mid;
            }else{
                begin = mid + 1;
            }
        }
        return end.intValue() - 1;/* if exactly sqrt cannot be found, return current found sqrt -1; */
    }
}
