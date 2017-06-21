/* Generate spiral matrix from 1~n^2 */
public class Solution {
    public int[][] generateMatrix(int n) {
        if(n <= 0) return new int[0][0];
        int[][] res = new int[n][n];
        int rowStart = 0, rowEnd = n-1;
        int colStart = 0, colEnd = n-1;
        int curNum = 1;
        while(rowStart <= rowEnd && colStart <= colEnd){
            for(int i = colStart; i <= colEnd; i++){
                res[rowStart][i] = curNum++;
            }
            rowStart++;
            for(int i = rowStart; i <= rowEnd; i++){
                res[i][colEnd] = curNum++;
            }
            colEnd--;
            if(rowStart <= rowEnd){
                for(int i = colEnd; i >= colStart; i--){
                    res[rowEnd][i] =curNum++;
                }
            }
            rowEnd--;
            if(colStart <= colEnd){
                for(int i = rowEnd; i >= rowStart; i--){
                    res[i][colStart] = curNum++;
                }
            }
            colStart++;
        }
        return res;
    }
}
