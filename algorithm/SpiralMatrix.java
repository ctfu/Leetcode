/* It is like squizing matrix borders into center in clockwise */
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return res;
        }
        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int colStart = 0;
        int colEnd = matrix[0].length - 1;
        while(rowStart <= rowEnd && colStart <= colEnd){
          /* traverse right */
            for(int i = colStart; i <= colEnd; i++){
                res.add(matrix[rowStart][i]);
            }
            rowStart++;
            /* traverse down */
            for(int i = rowStart; i <= rowEnd; i++){
                res.add(matrix[i][colEnd]);
            }
            colEnd--;
            /* traverse left */
            if(rowStart <= rowEnd){
                for(int i = colEnd; i >= colStart; i--){
                    res.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;
            /* travers up */
            if(colStart <= colEnd){
                for(int i = rowEnd; i >= rowStart; i--){
                    res.add(matrix[i][colStart]);
                }
            }
            colStart++;
        }
        return res;
    }
}
