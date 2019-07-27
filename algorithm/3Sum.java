/*
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/
/* Note: return unique set, need to remove duplicates */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 3) return res;
        Arrays.sort(nums);/* remember to sort the array */
        for(int i = 0; i < nums.length-2; i++){
            if(i == 0 || i > 0 && nums[i] != nums[i-1]){/* reduce duplicate at 3rd level */
                int begin = i+1, end = nums.length-1, target = 0-nums[i];
                while(begin < end){
                    if(nums[begin] + nums[end] == target){
                        res.add(Arrays.asList(nums[i], nums[begin], nums[end]));
                        /* reduce the duplcate in 2ed level */
                        while(begin < end && nums[begin] == nums[begin+1]) begin++;
                        while(begin < end && nums[end] == nums[end-1]) end--;
                        begin++; // remember to move one step further to get rid of duplicates
                        end--;
                    }else if(nums[begin] + nums[end] < target){
                        begin++;
                    }else{
                        end--;
                    }
                }
            }
        }
        return res;
    }
}
