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
