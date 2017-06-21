/* adding from the end */
public class Solution {
    public int[] plusOne(int[] digits) {
        for(int i = digits.length-1; i >= 0; i--){
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;  /* if not less than 9, then generates carry */
        }
        int[] newDigits = new int[digits.length + 1]; //if gets here, all previous are 0
        newDigits[0] = 1;
        return newDigits;
    }
}
