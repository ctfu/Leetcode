public class Solution {
    public boolean canJump(int[] nums) {
        int reachable = 0;  /* the array index (reachable distance) it can reachable so far */
        for(int i = 0; i < nums.length; i++){
            if(reachable < i) return false; /* if it can not even reach to my current position */
            reachable = Math.max(reachable, i+nums[i]); /* update reachable distance */
            if(reachable >= nums.length - 1){
                return true;
            }
        }
        return false;
    }
}
