/* concept is to used binary search */

public class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 0){
            return -1;
        }
        int begin = 0;
        int end = nums.length - 1;
        while(begin < end){     /* use begin < end, there could be one element*/
            int mid = begin + (end-begin)/2;
            if(nums[mid] > nums[end]){
                begin = mid + 1;
            }else{
                end = mid; /* because we use begin < end */
            }
        }
        return nums[begin];
    }
}
