class Solution {
    public int[][] imageSmoother(int[][] M) {
        int rows = M.length, cols = M[0].length;
        int[][] res = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int count = 0;
                int sum = 0;
                /* a technique to move the around the 9 cells */
                for (int r : new int[] {1, 0, -1}) {
                    for (int c : new int[] {1, 0, -1}) {
                        if (isValid(i + r, j + c, rows, cols)) {
                            count++;
                            sum += M[i + r][j + c];
                        }
                    }
                }
                res[i][j] = sum / count; // scale down calculation
            }
        }
        return res;
    }
    public boolean isValid(int x, int y, int rows, int cols) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}
