/* maintain multiple min-max intervals */
public class Solution {
    public boolean find132pattern(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        Stack<Interval> stack = new Stack<>();
        for(int i = 0; i < nums.length; i++){
            if(stack.empty() || nums[i] < stack.peek().min){ /* if nums[i] < min, start a new interval */
                stack.push(new Interval(nums[i], nums[i]));
            }else if(nums[i] > stack.peek().min){
                if(nums[i] < stack.peek().max) return true;
                else{       /* a new max has found, need to update the interval */
                    Interval last = stack.pop();
                    last.max = nums[i];
                    /* pop out those previous intervals that is included by current interval */
                    while(!stack.empty() && nums[i] > stack.peek().max){
                        stack.pop();
                    }
                    /* if there is any interval left, compare nums[i] with interval min */
                    if(!stack.empty() && nums[i] > stack.peek().min) return true;
                    stack.push(last);   /* push back the updated interval */
                }
            }
        }
        return false;
    }
    private class Interval{
        int min;
        int max;
        public Interval(int min, int max){
            this.min = min;
            this.max = max;
        }
    }
}
