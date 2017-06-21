/* Definition: an island is any adjacency land that surround by water */
/* Approach: DFS, consider as "DFS drowning isloand", problem becoms count number of 1s */
public class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int res = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                /* this position could an island, or just a pice of land of island */
                if(grid[i][j] == '1'){
                    markIsland(grid, i, j); /* mark its adjacency land of island */
                    res++;
                }
            }
        }
        return res;
    }
/* DFS to markIsland */
    public void markIsland(char[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1'){
            return;
        }
        grid[i][j] = '0';   /* mark the island to water */
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        for(int k = 0; k < 4; k++){
            markIsland(grid, i + dx[k], j + dy[k]);
        }
    }
}
/* BFS to markIsland, using queue to store land's position */
public void markIsland(char[][] grid, int x, int y){
    Queue<Integer> queue = new LinkedList<>();
    int rows = grid.length, cols = grid[0].length;
    queue.offer(x * cols + y); /* here is the trick, to store grid[x][y]'s index , for later bring its neighbors*/
    grid[x][y] = '0';
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    while(!queue.isEmpty()){
        int top = queue.poll();
        for(int i = 0; i < 4; i++){
            int nx = top/cols + dx[i], ny = top%cols + dy[i]; /* retore the position and move around */
            if(nx >= 0 && nx < rows && ny >= 0 && ny < cols && grid[nx][ny] == '1'){
                grid[nx][ny] = '0';
                queue.offer(nx * cols + ny);
            }
        }
    }
}
