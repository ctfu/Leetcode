public class Solution {
    public int shortestDistance(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int rows = grid.length, cols = grid[0].length;
        int[][] distance = new int[rows][cols]; /* to store sum of shortest distance to all building */
        int[][] reach = new int[rows][cols];    /* store how many buildings current index can reach to */
        int[] move = {0, 1, 0, -1, 0};  /* index for moving around */
        int buildings = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 1){    /* start walking from each building */
                    buildings++;    /* calculate the total buildings */
                    Queue<Integer> queue = new LinkedList<>();
                    boolean[][] visited = new boolean[rows][cols];
                    queue.offer(i * cols + j);  /* store the grid[i][j] position index */
                    int level = 0;
                    while(!queue.isEmpty()){
                        level++;
                        int size = queue.size();
                        for(int q = 0; q < size; q++){
                            int top = queue.poll();
                            for(int k = 0; k < 4; k++){
                                int x = top/cols + move[k], y = top%cols + move[k+1];
                                if(x >= 0 && x < rows && y >= 0 && y < cols &&  /* restore the index and move around */
                                            grid[x][y] == 0 && !visited[x][y]){
                                    distance[x][y] += level;    /* accumulate the distance to each building */
                                    reach[x][y]++;  /* accumulate the buildings the current space can reach to */
                                    visited[x][y] = true;
                                    queue.offer(x * cols + y);
                                }
                            }
                        }
                    }
                }
            }
        }
        int shortest = Integer.MAX_VALUE;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 0 && reach[i][j] == buildings){ /* if there is a space and the space can reach to all buildings */
                    shortest = Math.min(shortest, distance[i][j]);
                }
            }
        }
        return shortest == Integer.MAX_VALUE ? -1 : shortest;
    }
}
