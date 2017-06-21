/* The theroy is that the first person who is facing the number of */
/* stones left to remove is a multiple of 4 will lose.*/
public class Solution {
    public boolean canWinNim(int n) {
        if(n < 3){
            return true;
        }else{
            /* if it is not multiple of 4, than I can win */
            return n % 4 != 0;    /* the remainder should be the stones first pick */
        }
    }
}
