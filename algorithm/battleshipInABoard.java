public class Solution {
    public int countBattleships(char[][] board) {
        int count = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == '.') continue;
                if(i > 0 && board[i][j] == board[i-1][j]) continue;
                if(j > 0 && board[i][j] == board[i][j-1]) continue;
                count++;
            }
        }
        return count;
    }
}
