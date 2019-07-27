/*
Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.
Example 1:
Input:

0 0 0
0 1 0
0 0 0
Output:
0 0 0
0 1 0
0 0 0
Example 2:
Input:

0 0 0
0 1 0
1 1 1
Output:
0 0 0
0 1 0
1 2 1
Note:
The number of elements of the given matrix will not exceed 10,000.
There are at least one 0 in the given matrix.
The cells are adjacent in only four directions: up, down, left and right.
*/
/* BFS: 1. only starts with cells with zero, so non-zero cell distance will be +1 based on the starting cell
        2. if the newly calculated for a target cell's distance is greater than its cell valued, skip
        3. set all non-zero cell to Integer.MAX_VALUE initially */
public class Solution {
    public List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {
        int rows = matrix.size(), cols = matrix.get(0).size();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(matrix.get(i).get(j) == 0){
                    queue.offer(i * cols + j);
                }else{
                    matrix.get(i).set(j, Integer.MAX_VALUE);    /* set value */
                }
            }
        }
        int[] direct = {0, 1, 0, -1, 0};
        while(!queue.isEmpty()){        /* search from cell value as 0 */
            int top = queue.poll();
            for(int i = 0; i < direct.length-1; i++){
                int x = top/cols+direct[i], y = top%cols+direct[i+1];
                if(x >= 0 && x < rows && y >= 0 && y < cols
                    && matrix.get(x).get(y) != 0 && matrix.get(x).get(y) > matrix.get(top/cols).get(top%cols)+1){
                    matrix.get(x).set(y, matrix.get(top/cols).get(top%cols)+1);/* update cell value by adding one */
                    queue.offer(x * cols + y);
                }
            }
        }
        return matrix;
    }
}

// if the given output is a matrix, the disadvantage of this solution is that you need to
//modify the input matrix, should copy first in production code
// The advantage of starting from zero is that you can just update the cell value, if you start
// from 1, you will need to store how many steps till reaching the zero
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(i * cols + j);
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int[] direction = {0, 1, 0, -1, 0};
        while (!queue.isEmpty()) {
            int top = queue.poll();
            for (int k = 0; k < direction.length - 1; k++) {
                int x = top/cols + direction[k];
                int y = top%cols + direction[k+1];
                if (x >= 0 && x < rows && y >= 0 && y < cols &&
                   matrix[x][y] > 0 && matrix[x][y] > matrix[top/cols][top%cols] + 1) {
                    matrix[x][y] = matrix[top/cols][top%cols] + 1;
                    queue.offer(x * cols + y);
                }
            }
        }
        return matrix;
    }
}
