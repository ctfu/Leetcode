public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int aRows = A.length;
        int aCols = A[0].length;
        int bCols = B[0].length;
        int[][] res = new int[aRows][bCols];
        for (int i = 0; i < aRows; i++) {
            /* by switching rows and cols, making all row access, so memory is more efficient */
            for (int k = 0; k < aCols; k++) {
                if (A[i][k] != 0) {
                    for (int j = 0; j < bCols; j++) {
                        if (B[k][j] != 0) {
                            res[i][j] += A[i][k] * B[k][j];
                        }
                    }
                }
            }
        }
        return res;
    }
}
