/* Follow up: allows at most two duplicates */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null) return -1;
        if(nums.length < 3) return nums.length;

        /* start from index 2 to see if that number should be included */
        int index = 1;
        for(int i = 2; i < nums.length; i++){
            if(nums[i] != nums[index] || nums[i] != nums[index-1]){
                index++;
                nums[index] = nums[i];
            }
        }
        return index + 1;
    }
}
