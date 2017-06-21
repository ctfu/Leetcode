/* Dont need to keep trace of the whole board, only keep trace of each move placed on
 * each row, col, diagonal and antiDiagonal */
public class TicTacToe {
    private int[] rows; /* keep trace all the row movement */
    private int[] cols; /* keep trace of all cols movement */
    private int diagonal;   /* only one diagonal */
    private int antiDiagonal;   /* only one antiDiagonal */
    private int size;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        size = n;
        diagonal = 0;
        antiDiagonal = 0;
    }

    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int add = player == 1 ? 1 : -1; /* assigned 1 to player1's move, -1 to player2 */
        rows[row] += add;
        cols[col] +=add;
        if(row == col) diagonal += add;
        if((row+col) == size-1) antiDiagonal += add;
        /* if any row, col, diagonal, antiDiagonal adds up to size, someone wins */
        if(Math.abs(rows[row]) == size || Math.abs(cols[col]) == size || Math.abs(diagonal) == size
                                            || Math.abs(antiDiagonal) == size){
            return player;
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
