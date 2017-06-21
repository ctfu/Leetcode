/* Approach: BFS
 * Note: starts from the four boarders, because those are not surrounded by 'X',
 * which cannot be replaced by 'X' */
public class Solution {
    public void solve(char[][] board) {
        if(board.length == 0 || board[0].length == 0) return;
        int rows = board.length, cols = board[0].length;
        for(int i = 0; i < rows; i++){  /* search first, and last column */
            search(board, i, 0);
            search(board, i, cols-1);
        }
        for(int j = 0; j < cols; j++){  /* search first, and last rows */
            search(board, 0, j);
            search(board, rows-1, j);
        }
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                board[i][j] = board[i][j] == 'F' ? 'O' : 'X';
            }
        }
    }
    private void search(char[][] board, int x, int y){
        if(board[x][y] == 'X'){ /* based case */
            return;
        }
        Queue<Integer> queue = new LinkedList<>();
        int rows = board.length, cols = board[0].length;
        queue.offer(x*cols + y);
        board[x][y] = 'F';  /* replaced to 'F' */
        int[] dirct = {0, 1, 0, -1, 0};
        while(!queue.isEmpty()){
            int top = queue.poll();
            for(int i = 0; i < 4; i++){
                int nx = top/cols+dirct[i], ny = top%cols+dirct[i+1];
                if(nx >= 0 && nx < rows && ny >= 0 && ny < cols && board[nx][ny] == 'O'){
                    board[nx][ny] = 'F';
                    queue.offer(nx*cols + ny);
                }
            }
        }
    }
}
