/* Approach: store states in first element in the begining of each row (matrix[i][0])
 * and in the begining of each column (matrix[0][j]) to indicate if matrix[i][j] = 0
 * Becase first row and first colum will overlap, use seperate variable col0 to indicate
 * the states of column 0 */
public class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int col0 = -1; /* set the intial state of column0 as -1 */
        /* seperately deal with column0 with the rest of the columns */
        for(int i = 0; i < rows; i++){
            if(matrix[i][0] == 0) col0 = 0; /* column0 contains 0, set col0 to 0 */
            for(int j = 1; j < cols; j++){ /* starting from column 1 */
                /* if matrix[i][j] = 0, set the states in first elelment in each row and column */
                if(matrix[i][j] == 0){
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        for(int i = rows-1; i >= 0; i--){
            for(int j = cols-1; j >= 1; j--){ /* deal with other columns first, except 0*/
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0; /* if either of first element i's row or j's column, set 0 */
                }
            }
            /* make sure to set col0 later, so not to affect look up number */
            if(col0 == 0) matrix[i][0] = 0;/* deal with column0 */
        }
    }
}
