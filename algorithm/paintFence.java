/* Dp approach: consider previous two posts as a unit */
public class Solution {
    public int numWays(int n, int k) {
        if(n == 0) return 0;
        if(n == 1) return k;
        int preTwoDiffColor = k * (k-1);    /* if previous two posts have diff color */
        int preTwoSameColor = k;            /* if previous two posts have same color */
        for(int i = 2; i < n; i++){
            int diff = preTwoDiffColor, same = preTwoSameColor;
            /* if current post has diff color with its pre post
             * then previous two posts before current post can either have same color or different color */
            preTwoDiffColor = (same + diff) * (k-1);
            /* if cur post has same color as its previous post,
             * the previous two posts must have different color */
            preTwoSameColor = diff;
        }
        return preTwoSameColor + preTwoDiffColor;
    }
}
