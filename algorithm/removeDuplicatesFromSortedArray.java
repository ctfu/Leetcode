public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int n = 0;
        for(int i = 0; i < nums.length-1; i++){
            if(nums[i] != nums[i+1]){
                nums[n++] = nums[i];
            }
        }
        nums[n++] = nums[nums.length-1]; //add the last element
        return n;
    }
}
