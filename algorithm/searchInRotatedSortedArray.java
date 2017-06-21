/* Approach: Binary Search */
public class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0) return -1;
        int begin = 0;
        int end = nums.length-1;
        while(begin <= end){
            int mid = begin + (end-begin)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] >= nums[begin]){ /* if it is in the upper half, no duplicates, ">=" */
                if(target >= nums[begin] && target < nums[mid]){ /* if in the upper first half */
                    end = mid - 1;
                }else{
                    begin = mid + 1;
                }
            }else{
                if(target > nums[mid] && target <= nums[end]){
                    begin = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
