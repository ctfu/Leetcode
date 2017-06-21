/* Follow up change: houses are arraged in circle (
 * Difference:
 * 1. House Robber I: Robbing first house is freely at your choice
 * 2. Now rob or not rob first hourse has a restriction by the last house robb status
 * Solution:
 * Assume one house is not robbed, break the circle, so that it can be solved by house robber I technique
 * Example: If assume last house is not robbed, then house from 0-nums.length-2 is a consecutive house
 * We just need to compare the solution with when first house is not robbed */
public class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        /* Assume last hourse(or first house) not robbed to break the circle into
         * two parts, which could be solved by house robber I */
        return Math.max(rob(nums, 0, nums.length-2), rob(nums, 1, nums.length-1));
    }
    /* modification of House Robber I with a range of house */
    public int rob(int[] nums, int begin, int end){
        int preNo = 0, preYes = 0;
        for(int i = begin; i <= end; i++){
            int n = preNo, y = preYes;
            preNo = Math.max(n, y);
            preYes = n + nums[i];
        }
        return Math.max(preNo, preYes);
    }
}
