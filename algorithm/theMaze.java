/* BFS search
 * Note: The question is slightly different from the original Maze problem,
 * where the ball will only stop rolling if it hits the wall. So the ball may
 * rolling cross over the target destination */
public class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited  = new boolean[maze.length][maze[0].length];
        return solveMaze(maze, start[0], start[1], destination[0], destination[1], visited);
    }
    private boolean solveMaze(int[][] maze, int startX, int startY, int destX, int destY, boolean[][] visited){
        if(startX == destX && startY == destY) return true;
        int rows = maze.length, cols = maze[0].length;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startX * cols + startY);
        visited[startX][startY] = true;
        int[] dirct = {0, 1, 0, -1, 0};
        while(!queue.isEmpty()){
            int top = queue.poll();
            for(int k = 0; k < 4; k++){
                int nx = top/cols+dirct[k], ny = top%cols+dirct[k+1];
                /* for each direction, keep rolling in that direction until hits the wall, or out of bound */
                while(nx >= 0 && nx < rows && ny >= 0 && ny < cols && maze[nx][ny] == 0){
                    nx += dirct[k];
                    ny += dirct[k+1];
                }
                nx -= dirct[k]; /* if hits the wall(bounds are consider as walls), roll back one step, and check*/
                ny -= dirct[k+1];
                if(visited[nx][ny]) continue;   /* if visited, switch another direction */
                visited[nx][ny] = true;         /* if not, set visited */
                if(nx == destX && ny == destY){ /* check final destionation */
                    return true;
                }
                queue.offer(nx * cols + ny);    /* if not reach destination, added to the queue */
            }
        }
        return false;
    }
}
