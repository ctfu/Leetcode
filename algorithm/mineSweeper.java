/* DFS search
 * Note: recursivly search 8 direction only when the cell evaluates to 'B' */
public class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        play(board, click[0], click[1]);
        return board;
    }
    public void play(char[][] board, int x, int y){
        if(x < 0 || x >= board.length || y < 0 || y >= board[x].length){
            return;
        }
        if(board[x][y] == 'M'){ /* if is mine, stop */
            board[x][y] = 'X';
        }else if(board[x][y] == 'E'){   /* check if it is empty cell */
            /* count # of mines around board[x][y] for updating */
            int mineCount = 0;
            for(int i = -1; i < 2; i++){  /* check 8 cells around a cell */
                for(int j = -1; j < 2; j++){
                    if(i == 0 && j == 0) continue;
                    int nx = x + i, ny = y + j;
                    if(nx >= 0 && nx < board.length && ny >= 0 && ny < board[x].length && board[nx][ny] == 'M'){
                        mineCount++;
                    }
                }
            }
            if(mineCount > 0){
                board[x][y] = (char)(mineCount + '0');  /* convert to char, important to + '0' */
            }else{
                board[x][y] = 'B';  /* recursivly search around when evaluates to 'B' */
                for(int i = -1; i < 2; i++){
                    for(int j = -1; j < 2; j++){
                        if(i == 0 && j == 0) continue;
                        int nx = x+i, ny = y+j;
                        play(board, nx, ny);
                    }
                }
            }
        }
    }
}
