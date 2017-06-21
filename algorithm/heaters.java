/* BinarySearch: binarySearch each house position from heaters array */
/* Note: must sort heaters array */
public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters); /* sort heaters */
        int res = Integer.MIN_VALUE;
        for(int house : houses){
            int index = Arrays.binarySearch(heaters, house);/* search each house position */
            if(index < 0){
                index = -(index+1);
            }
            /* find out the distance from left, and right heater and get the smaller on for each house */
            /* houses maynot have left or right heaters: [1,2,3] [2]
             * 1->index 0(not left heater), 2->index return 1 (not right heater)
             * a house must either has a left or right heater */
            int toLeft = index -1 >= 0 ? house-heaters[index-1] : Integer.MAX_VALUE;
            int toRight = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;
            res = Math.max(res, Math.min(toLeft, toRight));
        }
        return res;
    }
}
