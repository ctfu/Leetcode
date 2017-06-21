/* Expand each number to one distance left and right to check if it is in a search set,
 * if exists, remove the number and move the pointr */
public class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>(); /* copy the number to set for searching */
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }
        int len = 0;
        for(int i = 0; i < nums.length; i++){
            int left = nums[i]-1; /* expand to left */
            while(set.contains(left)){
                set.remove(left);
                left--;
            }
            int right = nums[i]+1;  /* expand to right */
            while(set.contains(right)){
                set.remove(right);
                right++;
            }
            len = Math.max(len, right-left-1);
        }
        return len;
    }
}
