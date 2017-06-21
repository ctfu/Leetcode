/* Assum all the clothes can be qually distributed to all the machines
 * Convert the current array to a loss/gain array */
public class Solution {
    public int findMinMoves(int[] machines) {
        if(machines == null || machines.length == 0) return 0;
        int total = 0;
        int avg = 0;
        for(int m : machines) total += m; /* accumulate total clothes */
        if(total % machines.length != 0){ /* if the clothes cann't be qually ditributed */
            return -1;
        }
        avg = total / machines.length;    /* if can, calculate the expected work load for each machine */

        int count = 0;
        int max = 0;
        /* current load - expected work load = currnet machine finish status
         * if equally distributed, the finished status should be 0
         * We dont care how the machine passes clothes to reach 0 status, we set the status to 0
         * by moving the status work load to the next machine */
        for(int load : machines){
            count += load - avg; /* count is accumulated needed to passes clothes */
            max = Math.max(max, Math.max(Math.abs(count), load-avg));
        }
        return max;
    }
}
