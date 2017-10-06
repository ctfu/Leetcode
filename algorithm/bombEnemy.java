/* Solution 1*/
class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '0') {
                    res = Math.max(res, getEnemy(grid, i, j));
                }
            }
        }
        return res;
    }
    public int getEnemy(char[][] grid, int x, int y) {
        int row = 0;
        for (int i = x; i >= 0; i--) {
            if (grid[i][y] == 'W') {
                break;
            } else if (grid[i][y] == '0') {
                continue;
            } else {
                row++;
            }
        }
        for (int i = x; i < grid.length; i++) {
            if (grid[i][y] == 'W') {
                break;
            } else if (grid[i][y] == '0') {
                continue;
            } else {
                row++;
            }
        }
        int col = 0;
        for (int i = y; i >= 0; i--) {
            if (grid[x][i] == 'W') {
                break;
            } else if (grid[x][i] == '0') {
                continue;
            } else {
                col++;
            }
        }
        for (int i = y; i < grid[x].length; i++) {
            if (grid[x][i] == 'W') {
                break;
            } else if (grid[x][i] == '0') {
                continue;
            } else {
                col++;
            }
        }
        return row + col;
    }
}

/* solution 2 */
class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if(grid == null || grid.length == 0 ||  grid[0].length == 0) return 0;
        int max = 0;
        int row = 0;
        int[] col = new int[grid[0].length];
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length;j++){
                if(grid[i][j] == 'W') continue;
                if(j == 0 || grid[i][j-1] == 'W'){
                    row = killedEnemiesRow(grid, i, j);
                }
                if(i == 0 || grid[i-1][j] == 'W'){
                    col[j] = killedEnemiesCol(grid,i,j);
                }
                if(grid[i][j] == '0'){
                    max = (row + col[j] > max) ? row + col[j] : max;
                }
            }

        }

        return max;
    }

    //calculate killed enemies for row i from column j
    private int killedEnemiesRow(char[][] grid, int i, int j){
        int num = 0;
        while(j <= grid[0].length-1 && grid[i][j] != 'W'){
            if(grid[i][j] == 'E') num++;
            j++;
        }
        return num;
    }
    //calculate killed enemies for  column j from row i
    private int killedEnemiesCol(char[][] grid, int i, int j){
        int num = 0;
        while(i <= grid.length -1 && grid[i][j] != 'W'){
            if(grid[i][j] == 'E') num++;
            i++;
        }
        return num;
    }
}
