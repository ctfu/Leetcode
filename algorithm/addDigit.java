/* Using the concept of digital root (repeated digital sum), for a non-negative number */
/* except 0 and the multiple of 9, the digital root is n % 9 */
public class Solution {
    public int addDigits(int num) {
       if(num == 0){
           return 0;
       }else if( num % 9 == 0){
           return 9;
       }else{
           return num % 9;
       }
    }
}
