public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int leftRecArea = (C - A) * (D - B);
        int rightRecArea = ((G - E) * (H - F));

        //calculate the overlap area
        int overlap = 0;
        int left = Math.max(A, E);
        int right = Math.min(C, G);
        int top = Math.min(D, H);
        int bottom = Math.max(B, F);
        if(right > left && top > bottom){
            overlap = (right - left) * (top - bottom);
        }
        return leftRecArea + rightRecArea - overlap;
    }
}
