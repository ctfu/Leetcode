/*
Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a subsequence
ai, aj, ak such that i < j < k and ai < ak < aj. Design an algorithm that takes
a list of n numbers as input and checks whether there is a 132 pattern in the list.

Note: n will be less than 15,000.

Example 1:
Input: [1, 2, 3, 4]

Output: False

Explanation: There is no 132 pattern in the sequence.
Example 2:
Input: [3, 1, 4, 2]

Output: True

Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
Example 3:
Input: [-1, 3, 2, 0]

Output: True

Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
*/
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
                    while(!stack.empty() && nums[i] >= stack.peek().max){
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
