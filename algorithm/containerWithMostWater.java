/* Idea is to start from both end, exhauste every line's capacity of storing water
 * if left line is smaller,(left line capacity exhausted), move index forward
 * if right line is smaller, move index backward. */

 /* Note: here line has no width, in between is gaurrantee can contain water
          trapping water or largest historam problem line has width */
public class Solution {
    public int maxArea(int[] height) {
        int begin = 0, end = height.length - 1;
        int area = 0;
        while(begin < end){
            /* current area capacity is whichever lower line * width */
            /* be award here use (end-begin) */
            area = Math.max(area, (end - begin) * Math.min(height[begin], height[end]));
            if(height[begin] < height[end]){ /* left line capcity exhaused */
                begin++;
            }else{
                end--;
            }
        }
        return area;
    }
}
