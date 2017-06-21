public class Solution {
    /*take advantage XOR property to solve problem
     * A XOR A is 0, 0 XOR A is A, and XOR is communative */
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int i = 0; i < nums.length; i++){
            result = result ^ nums[i];
        }
        return result;
    }
}
