public class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        return solveMaze(maze, start[0], start[1], destination[0], destination[1]);
    }
    public int solveMaze(int[][] maze, int startX, int startY, int destX, int destY){
        if(startX == destX && startY == destY) return 0;
        int rows = maze.length, cols = maze[0].length;
        int[][] path = new int[rows][cols]; /* store the min distance from starting point */
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                path[i][j] = Integer.MAX_VALUE;
            }
        }
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(startX, startY, 0));
        int[] dirct = {0, 1, 0, -1, 0};
        while(!queue.isEmpty()){
            Point top = queue.poll();
            if(path[top.x][top.y] <= top.distance) continue;/* if already exists a shorter route */
            path[top.x][top.y] = top.distance;
            for(int k = 0; k < 4; k++){
                int nx = top.x + dirct[k], ny = top.y + dirct[k+1], distance = top.distance;
                while(nx >= 0 && nx < rows && ny >= 0 && ny < cols && maze[nx][ny] == 0){
                    nx += dirct[k];
                    ny += dirct[k+1];
                    distance++;
                }
                nx -= dirct[k];
                ny -= dirct[k+1];
                queue.offer(new Point(nx, ny, distance));
            }
        }
        return path[destX][destY] == Integer.MAX_VALUE ? -1 : path[destX][destY];
    }
    /* a custome object point to store the cell cordinate and the distance away from starting point */
    class Point{
        int x;
        int y;
        int distance;
        public Point(int x, int y, int distance){
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}
