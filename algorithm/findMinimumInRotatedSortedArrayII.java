/* concept is to used binary search */

public class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 0){
            return -1;
        }
        int begin = 0;
        int end = nums.length - 1;
        while(begin < end){
            int mid = begin + (end - begin)/2;
            if(nums[mid] > nums[end]){
                begin = mid + 1;
            }else if(nums[mid] < nums[end]){
                end = mid;
            }else{    /* when nums[mid] == nums[end], not sure which half */
                end--;
            }
        }
        return nums[begin];
    }
}
