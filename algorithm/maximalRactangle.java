/* Record the height array at each row (1 is height 1)
 * Use the technique of "Largest Rectangle in Historgram" to calculate the rectangel */
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return 0;
        int rows = matrix.length, cols = matrix[0].length;
        int[] heights = new int[cols+1];
        heights[cols] = 0;  /* this trick is to make sure stack is empty when get out of the for loop */
        int res = 0;
        for(int i = 0; i < rows; i++){
            Stack<Integer> stack = new Stack<>();
            for(int j = 0; j < cols+1; j++){
                if(j < cols){
                    if(matrix[i][j] == '1'){
                        heights[j] += 1;    /* accumulate the height */
                    }else{
                        heights[j] = 0;
                    }
                }
                if(stack.empty() || heights[stack.peek()] < heights[j]){
                    stack.push(j);
                }else{
                    while(!stack.empty() && heights[stack.peek()] >= heights[j]){
                        int heigh = heights[stack.pop()];
                        int width = stack.empty() ? j : (j-stack.peek()-1);
                        res = Math.max(res, heigh * width);
                    }
                    stack.push(j);
                }
            }
        }
        return res;
    }
}
