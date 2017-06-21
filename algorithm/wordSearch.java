public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board.length == 0 || board[0].length == 0) return false;
        /* need visited to prevent duplicate visite */
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                /* using control index: 1) control search length 2) compare search character with word char sequence */
                if(wordSearch(board, i, j, word, visited, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean wordSearch(char[][] board, int i, int j, String word, boolean[][] visited, int index){
        if(index == word.length()){
            return true;
        }
        if(i < 0 || i >= board.length || j < 0 || j >= board[i].length || visited[i][j]
                                        || board[i][j] != word.charAt(index)){
            return false;
        }
        int[] dir = {0, 1, 0, -1, 0}; /* moving direction array */
        for(int k = 0; k < 4; k++){
            visited[i][j] = true;
            if(wordSearch(board, i+dir[k], j+dir[k+1], word, visited, index+1)){
                return true;
            }
            visited[i][j] = false; /* important to get rid of reference */
        }
        return false;
    }
}
