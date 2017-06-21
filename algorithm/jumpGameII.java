/* greedy, always choose maximum to jump */
public class Solution {
    public int jump(int[] nums) {
        int curReachable = 0;   /* current maximum reachable index */
        int lastReachable = 0;  /* last maximum reachable index */
        int step = 0;
        for(int i = 0; i < nums.length-1; i++){ /* here is < nums.length-1 */
            curReachable = Math.max(curReachable, i+nums[i]);
            if(i == lastReachable){
                step++;
                lastReachable = curReachable;
            }
        }
        return step;
    }
}
