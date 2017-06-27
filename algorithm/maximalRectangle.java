/* Record the height array at each row (1 is height 1)
 * Use the technique of "Largest Rectangle in Historgram" to calculate the rectangel */
 public class Solution {
     public int maximalRectangle(char[][] matrix) {
         if (matrix.length == 0 || matrix[0].length == 0) {
             return 0;
         }
         int[] heights = new int[matrix[0].length + 1];
         heights[matrix[0].length] = 0; // this is a trick to force pop the stack when reach end of the column
         int res = 0;
         for (int i = 0; i < matrix.length; i++) {
             Stack<Integer> stack = new Stack<>();
             for (int j = 0; j < matrix[i].length; j++) {
                 if (matrix[i][j] == '1') {
                     heights[j] += 1;
                 } else {
                     heights[j] = 0;    // set accumulated heights to 0
                 }
             }
             // below is larget rectange in a historgram 
             for (int k = 0; k < heights.length; k++) {
                 if (stack.empty() || heights[stack.peek()] < heights[k]) {
                     stack.push(k);
                 } else {
                     int h = heights[stack.pop()];
                     int w = stack.empty() ? k : (k - stack.peek() - 1);
                     res = Math.max(res, h * w);
                     k--;
                 }
             }
         }
         return res;
     }
 }
