/* Consider the even, old index position for each number */
public class Solution {
    public void wiggleSort(int[] nums) {
        for(int i = 1; i < nums.length; i++){
            if(i % 2 != 0){ /* if in the old index */
                if(nums[i-1] > nums[i]) swap(nums, i-1, i);
            }else if(nums[i-1] < nums[i]) swap(nums, i-1, i);/* if even index */
        }
    }
    public void swap(int[] nums, int first, int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
