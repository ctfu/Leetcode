Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target.
Return the sum of the three integers. You may assume that each input would have exactly one solution.

Example:

Given array nums = [-1, 2, 1, -4], and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
--------------------------------------------------------------------------------
/* Asssumption: You may assume each input has exacly one solution */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        /* ask about if nums size will less than 3 */
        Arrays.sort(nums);/* remember to sort */

        int res = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length - 2; i++){
            int begin = i + 1, end = nums.length-1;
            while(begin < end){
                /* check which one is closer to target */
                int sum = nums[i] + nums[begin] + nums[end];
                if(Math.abs(target - sum) < Math.abs(target - res)){
                    res = sum;
                    if(res == target) return res;/* if res == target, closest you can get */
                }else{
                    if(sum > target){ /* can we get a sum closer to target? important */
                        end--;
                    }else{
                        begin++;
                    }
                }
            }
        }
        return res;
    }
}
