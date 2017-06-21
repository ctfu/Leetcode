/* 1. Loop through the matrix, count # of lands
 * 2. Count land's right and down neighbors (if a land has right neighbor, it must be a left neighbor of other cell)
 * 3. 4 * land - 2 * overlap */
public class Solution {
    public int islandPerimeter(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        int land = 0;
        int overlap = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1){
                    land++;
                    if(i < grid.length-1 && grid[i][j] == grid[i+1][j]) overlap++;/* count down neighbors */
                    if(j < grid[i].length-1 && grid[i][j] == grid[i][j+1]) overlap++;/* count right neighbors */
                }
            }
        }
        return 4 * land - 2 * overlap;
    }
}
