public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        /* one dimenttion array to represent the board
         * each index in the array represents one row,
         * each cell stores the column index of the target queen position */
        int[] board = new int[n]; /* create a board */
        putQueens(res, board, 0);
        return res;
    }
    private void putQueens(List<List<String>> res, int[] board, int row){
        if(row == board.length){
            saveResults(res, board);
        }else{
            for(int col = 0; col < board.length; col++){
                if(isLegal(board, row, col)){
                    board[row] = col;
                    putQueens(res, board, row + 1);
                }
            }
        }
    }
    private boolean isLegal(int[] board, int row, int col){
        for(int i = row-1; i>= 0; i--){
            /* board[i] == col: check if any previous rows queen positions in the same colunm
             * board[i] - col == Math.abs(row - i): check the diagonals difference */ 
            if(board[i] == col || Math.abs(board[i] - col) == Math.abs(row - i)){
                return false;
            }
        }
        return true;
    }
    private void saveResults(List<List<String>> res, int[] board){
        List<String> temp = new ArrayList<>();
        for(int i = 0; i < board.length; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < board.length; j++){
                if(j == board[i]){
                    sb.append('Q');
                }else{
                    sb.append('.');
                }
            }
            temp.add(sb.toString());
        }
        res.add(temp);
    }
}
