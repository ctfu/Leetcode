/* Important: requarement of the problem:
 * 1. Must updat the board at the same time, can't utilized partial update reuslt to update
 * Need to have a way to store the next update status, while preserving the current status
 * Solution: Using two bit to represent 00 (nextStat, curSta)
 * board[i][j] & 1 to text first bit, board[i][j] >>= 1 to get the next bit
 * so the two bits can operate independently */
public class Solution {
    public void gameOfLife(int[][] board) {
        if(board.length == 0 || board[0].length == 0){
            return;
        }
        int rows = board.length, cols = board[0].length;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                int lives = neighborLives(board, rows, cols, i, j);
                /* if cell is 1, neighbor cell 1s need to be [2, 3] to become live*/
                if(board[i][j] == 1 && lives >= 2 && lives <= 3){
                    board[i][j] = 3; /* assign 3 (11), to presrve currentStat for other cell's calculation */
                /* if cell is 0, neighbor cell 1s need to be exactly 3 to become live */
                }else if(board[i][j] == 0 && lives == 3){
                    board[i][j] = 2;/* assign 2 (10), to presrve currentStat for other cell's calculation */
                }
            }
        }
        /* right shift one bit to get the next update */
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                board[i][j] >>= 1;
            }
        }
    }
    /* A method to test the 8 neighbor cells 1s and 0s */
    public int neighborLives(int[][] board, int rows, int cols, int i, int j){
        int lives = 0;
        /* important to maintain the boundary */
        for(int x = Math.max(i-1, 0); x <= Math.min(i+1, rows-1); x++){
            for(int y = Math.max(j-1, 0); y <= Math.min(j+1, cols-1); y++){
                lives += board[x][y] & 1;
            }
        }
        lives -= board[i][j] & 1; /* dont forget to substract the cell itself */
        return lives;
    }
}
