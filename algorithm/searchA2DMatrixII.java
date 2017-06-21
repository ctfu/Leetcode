/* 1. Integers in each row are sorted in ascending from left to right.
 * 2. Integers in each column are sorted in ascending from top to bottom. */
/* Approach: Compare with the upper right element, (greatest in the first row, smallest in the last column)
 * By comparing with this number, can get rid of one row or columm each time */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) return false;
        int row = 0;
        int col = matrix[0].length - 1;
        while(row < matrix.length && col >= 0){
            if(target == matrix[row][col]){
                return true;
            }else if(target > matrix[row][col]){ /* get rid of one row */
                row++;
            }else{
                col--;  /* get rid of one column */
            }
        }
        return false;
    }
}
