/* Positive number whose prime factor only include 2, 3, 5, indicates it can only be divided by 2, 3, 5 */
public class Solution {
    public boolean isUgly(int num) {
       if(num <= 0) return false;
       if(num == 1) return true;
       while(num % 2 == 0) num /=2;
       while(num % 3 == 0) num /= 3;
       while(num % 5 == 0) num /= 5;
       return num == 1;
    }
}
