/* two pointers from both sizes
 * when left size <= right size, fill water from left
 * when left size > right size, fill water form right
 * there is a capacity only when current bar is less than the maxleft or maxright bar */
public class Solution {
    public int trap(int[] height) {
        if(height == null ||height.length == 0) return 0;
        int begin = 0, end = height.length - 1;
        int maxLeft = 0, maxRight = 0;
        int res = 0;
        while(begin < end){
            if(height[begin] <= height[end]){   /* fill water from left */
                if(height[begin] < maxLeft){    /* found a bar that can hold water(capacity) */
                    res += maxLeft - height[begin]; /* otherwise this bar can't hold any water */
                }else{
                    maxLeft = height[begin];
                }
                begin++;
            }else{                              /* fill water from right size */
                if(height[end] < maxRight){
                    res += maxRight - height[end];
                }else{
                    maxRight = height[end];
                }
                end--;
            }
        }
        return res;
    }
}


/* monatonic stack approach
 * decreasing stack:
 * how to decide stack.peek() value ? see if it has potential to trap water */
 public class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int area = 0;
        for(int i = 0; i < height.length; i++){
            if(stack.size() == 0 || height[stack.peek()] > height[i]){
                stack.push(i);
            }else{
                int temp = height[stack.pop()];
                int width = stack.empty() ? i : i - stack.peek() - 1;
                int h = stack.empty() ? 0 : Math.min(height[i]-temp, height[stack.peek()]-temp);
                area += h * width;
                i--;
            }
        }
        /* no need to do the rest here becase there is no more higher bar
         * on the right to trap water, even through the stack is not empty */
        return area;
    }
}
