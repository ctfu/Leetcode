/* add 1 to n-1 elements in the array, is essentially the same as
 * subtracting 1 from one element from the array.
 * Best way to solve it is to make all elements equals to the min element */
public class Solution {
    public int minMoves(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int res = 0;
        int min = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < min){
                min = nums[i];
            }
        }
        for(int n : nums){
            res += n - min;
        }
        return res;
    }
}
