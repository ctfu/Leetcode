/*
Given an array of n integers nums and a target, find the number of index triplets
i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.

Example:

Input: nums = [-2,0,1,3], and target = 2
Output: 2
Explanation: Because there are two triplets which sums are less than 2:
             [-2,0,1]
             [-2,0,3]
*/
/* Two pointers with 2 sum */
public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if(nums == null || nums.length < 3) return 0;
        Arrays.sort(nums);
        int res = 0;
        for(int i = 0; i < nums.length-2; i++){
            int begin = i + 1, end = nums.length - 1;
            while(begin < end){
                if(nums[i]+nums[begin]+nums[end] < target){
                    res += (end - begin); /* any number between begin to end are smaller */
                    begin++;
                }else{
                    end--;  /* move end pointer to get smaller number */
                }
            }
        }
        return res;
    }
}
