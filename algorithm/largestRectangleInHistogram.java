/* Method: monotonic stack (increasing) */
public class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for(int i = 0; i < heights.length; i++){
            if(stack.empty() || heights[stack.peek()] < heights[i]){
                stack.push(i);
            }else{
                int heigh = heights[stack.pop()];
                int width = stack.empty() ? i : i-stack.peek()-1;
                res = Math.max(res, heigh * width);
                i--;
            }
        }
        while(!stack.empty()){
            int heigh = heights[stack.pop()];
            int width = stack.empty() ? heights.length : heights.length-stack.peek()-1;
            res = Math.max(res, heigh * width);
        }
        return res;
    }
}
