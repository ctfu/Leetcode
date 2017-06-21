/* Follow up for "searchInRotatedSortedArray", if duplicates are allow,
 * the worst case is o(n), if all numbers are the same, has to move step by step */
public class Solution {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return false;
        int begin = 0, end = nums.length-1;
        while(begin <= end){ /* searching target, put "<=" */
            int mid = begin + (end-begin)/2;
            if(nums[mid] == target) return true;
            if(nums[mid] > nums[begin]){
                if(target >= nums[begin] && target < nums[mid]){
                    end = mid -1;
                }else{
                    begin = mid + 1;
                }
            }else if(nums[mid] < nums[begin]){
                if(target > nums[mid] && target <= nums[end]){
                    begin = mid + 1;
                }else{
                    end = mid - 1;
                }
            }else{  /* if duplicates are allow, cannot decide which half, move step by step */
                begin++;
            }
        }
        return false;
    }
}
