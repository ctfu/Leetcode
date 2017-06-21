/* Note: requirement searching for third max distinct number */
public class Solution {
    public int thirdMax(int[] nums) {
        /* using object Integer type to avoid input is Integer.MIN_VALUE problem
         * such as [0, Integer.MIN_VALUE, Integer.MIN_VALUE], if initilized three
         * variable to Integer.MIN_VALUE will have problems when returning */
        Integer max = null;
        Integer mid = null;
        Integer small = null;
        for(Integer n : nums){ /* need to convert nums to Integer */
            /* primitive and null don't have equals method */
            if(n.equals(max) || n.equals(mid) || n.equals(small)){  /* only for distinct numbers */
                continue;
            }else if(max == null || n > max){
                small = mid;
                mid = max;
                max = n;
            }else if(mid == null || n > mid){
                small = mid;
                mid = n;
            }else if(small == null || n > small){
                small = n;
            }
        }
        return small == null ? max : small; /* check if third max exist */
    }
}
