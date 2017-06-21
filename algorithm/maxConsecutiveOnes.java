public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int res = 0, localMax = 0;
        for(int i = 0; i < nums.length-1; i++){
            if(nums[i] == 1 && nums[i] == nums[i+1]){
                localMax++;
            }else if(nums[i] == 1){
                res = Math.max(res, localMax+1);
                localMax = 0;
            }
        }
        /* it is important to check the last position number to catch the
         * cases such as [0, 1,1] */
        if(nums[nums.length-1] == 1) res = Math.max(res, localMax + 1);
        return res;
    }
}
