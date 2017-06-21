/* Two binary search, first for start position, second for end position */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if(nums.length == 0) return res;
        int begin = 0, end = nums.length-1;
        while(begin < end){ /* carful here is "<" */
            int mid = begin + (end-begin)/2;
            if(nums[mid] < target) begin = mid + 1;
            else{
                /* if (nums[mid] == target) search on the left or at mid (end = mid)
                 * if(nums[mid] > target) search on the left (end = mid -1) */
                end = mid;  /* merge last two cases */
            }
        }
        if(nums[begin] != target) return res;   /* if target is not found */
        res[0] = begin;
        end = nums.length-1;
        while(begin < end){
            int mid = begin + (end-begin)/2 + 1; /* let th mid biased to the right, otherwise begin won't move */
            if(nums[mid] > target) end = mid -1;
            else{
                begin = mid;
            }
        }
        res[1] = begin;
        return res;
    }
}
