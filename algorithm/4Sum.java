Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:

The solution set must not contain duplicate quadruplets.

Example:

Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
--------------------------------------------------------------------------------
/* forloop, underneath it is 3sum, the number could be duplicate, important to remove duplicate */
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 4) return res;
        Arrays.sort(nums);/* remember to sort */

        for(int i = 0; i < nums.length - 3; i++){
            if(i == 0 || i > 0 && nums[i] != nums[i-1]){/* check 4th level duplicate */
                for(int j = i+1; j < nums.length - 2; j++){
                    if(j == i+1 || j > i+1 && nums[j] != nums[j-1]){/* check 3rd level duplicate */
                        int begin = j+1, end = nums.length-1;
                        int newTarget = target-nums[i]-nums[j];
                        while(begin < end){
                            if(nums[begin] + nums[end] == newTarget){
                                res.add(Arrays.asList(nums[i], nums[j], nums[begin], nums[end]));
                                /* check 2ed level duplicate */
                                while(begin < end && nums[begin] == nums[begin+1]) begin++;
                                while(begin < end && nums[end] == nums[end-1]) end--;
                                begin++;
                                end--;
                            }else if(nums[begin] + nums[end] > newTarget){
                                end--;
                            }else{
                                begin++;
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}
