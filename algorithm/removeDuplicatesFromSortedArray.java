/* Start from first element, included only if it is not duplicated */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null) return -1;
        if(nums.length < 2) return nums.length; /* important to check length here */

        int index = 0;
        for(int i = 1; i < nums.length; i++){
            /* dont care the first element, only includes nums[i] if is not duplicated */
            if(nums[i] != nums[index]){
                index++;
                nums[index] = nums[i];
            }
        }
        return index + 1;
    }
}
