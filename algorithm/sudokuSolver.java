/* Backtracking */
public class Solution {
    public void solveSudoku(char[][] board) {
        if(board.length == 0 || board[0].length == 0) return;
        solve(board);
    }
    public boolean solve(char[][] board){ /* here return type is boolean to indicate solvable */
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == '.'){
                    for(char a = '1'; a <= '9'; a++){
                        if(isValid(board, i, j, a)){
                            board[i][j] = a;
                            if(solve(board)){
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false;   /* if not valid option, then return false */
                }
            }
        }
        return true;
    }
    /* check valid for row, column and cube */
    public boolean isValid(char[][] board, int x, int y, char c){
        for(int i = 0; i < 9; i++){
            if(board[x][i] != '.' && board[x][i] == c) return false;
            if(board[i][y] != '.' && board[i][y] == c) return false;
            if(board[3*(x/3) + i/3][3*(y/3) + i%3] != '.' && board[3*(x/3) + i/3][3*(y/3) + i%3] == c) return false;
        }
        return true;
    }
}
