/* The numbers repeats at most 3 times, using bit manipulation */

/* Number appears three times:
 * Firs time: store the number in ones
 * second time: clears ones, stores the number in twos
 * third time: try to store the number in ones, but two clears it with ~twos */
public class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for(int i = 0; i < nums.length; i++){
            ones = (ones ^ nums[i]) & ~twos;
            twos = (twos ^ nums[i]) & ~ones;
        }
        return ones;
    }
}
