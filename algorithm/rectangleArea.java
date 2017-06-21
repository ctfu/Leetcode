/* The approach: anticipate the overlap boundary, which will be the boundaries of
 * the rectange */
public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int leftRecArea = (C - A) * (D - B);
        int rightRecArea = ((G - E) * (H - F));

        int overlap = 0;
        /* define the overlap boundary */
        int left = Math.max(A, E); /* go as left as the other retangle's left boundary */
        int right = Math.min(C, G);
        int top = Math.min(D, H);
        int bottom = Math.max(B, F);
        /* the valid condition that there will be overlap */
        if(right > left && top > bottom){
            overlap = (right - left) * (top - bottom);
        }
        return leftRecArea + rightRecArea - overlap;
    }
}
