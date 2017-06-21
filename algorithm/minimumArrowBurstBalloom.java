/* sort points by start position, check for interval overlap */
public class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0) return 0;
        /* sort by start position, if same start, sort by end position */
        Arrays.sort(points, (a, b) ->{
            if(a[0] != b[0]){
                return a[0] -b[0];
            } else{
                return a[1]-b[1];
            }
        });
        int res = 1;
        int preEnd = points[0][1];
        for(int[] p : points){
            if(p[0] <= preEnd){ /* if there is overlap, assign end to whichever the smallest */
                preEnd = Math.min(preEnd, p[1]);
            }else{  /* otherwise need one more arrow */
                res++;
                preEnd = p[1];
            }
        }
        return res;
    }
}
