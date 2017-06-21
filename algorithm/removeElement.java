/* Doesnot matter what leaves beyond the new length */
public class Solution {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}
