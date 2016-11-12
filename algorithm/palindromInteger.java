public class Solution {
    //the key idea is to reverse the interger
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int p = x, q = 0;
        while(p >= 10){
            q *= 10;
            q += p % 10;
            p /= 10;
        }
        //the format will be example 12321: 1232 == 12321 / 10 && 1 == 12321 % 10
        return q == x /10 && p == x % 10; //can just get rid of p == x % 10.
    }
}
