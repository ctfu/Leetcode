class NumMatrix {
    private int[][] rsum;
    public NumMatrix(int[][] matrix) {
        if (matrix.length != 0) {
            rsum = new int[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                rsum[i][0] = matrix[i][0];
                for (int j = 1; j < matrix[i].length; j++) {
                    rsum[i][j] = matrix[i][j] + rsum[i][j - 1];
                }
            }
        }
    }

    // o(n) time for the sum region
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        if (col1 == 0) {
            for (int i = row1; i <= row2; i++) {
                sum += rsum[i][col2];
            }
        } else {
            for (int i = row1; i <= row2; i++) {
                sum += rsum[i][col2] - rsum[i][col1 - 1];
            }
        }
        return sum;
    }
}

// approach 2 to make sumRegion constant time
class NumMatrix {
    private int[][] rsum;
    public NumMatrix(int[][] matrix) {
        if (matrix.length != 0 && matrix[0].length != 0) {
            int rows = matrix.length, cols = matrix[0].length;
            rsum = new int[rows + 1][cols + 1];
            for (int i = 1; i <= rows; i++) {
                for (int j = 1; j <= cols; j++) {
                    rsum[i][j] = matrix[i - 1][j - 1] + rsum[i][j - 1] + rsum[i - 1][j] - rsum[i - 1][j - 1];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return rsum[row2 + 1][col2 + 1] - rsum[row2 + 1][col1] - rsum[row1][col2 + 1] + rsum[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
