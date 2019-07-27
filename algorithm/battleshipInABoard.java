/*
Given an 2D board, count how many battleships are in it. The battleships are
 represented with 'X's, empty slots are represented with '.'s.
 1. You receive a valid board, made of only battleships or empty slots.
 Battleships can only be placed horizontally or vertically.
 2. there are no adjacent battleships.
 Example:
X..X
...X
...X
In the above board there are 2 battleships.
Invalid Example:
...X
XXXX
...X
This is an invalid board that you will not receive - as battleships will always
have a cell separating between them.
Follow up:
Could you do it in one-pass, using only O(1) extra memory and without
modifying the value of the board?
*/
public class Solution {
    public int countBattleships(char[][] board) {
        int count = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == '.') continue;
                /* dont need to check the first cell */
                if(i > 0 && board[i][j] == board[i-1][j]) continue;
                if(j > 0 && board[i][j] == board[i][j-1]) continue;
                count++;
            }
        }
        return count;
    }
}
