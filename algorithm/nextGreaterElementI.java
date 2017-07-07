/* Observation is that for example [5, 4, 3, 2, 1, 6], if encounter 6, all previous value if push in the stack
 * their next greater element is 6. So keep a drcrease monotonic stack and HashMap for <Element, NextGreaterElement>
 * time complexity: worse case O(n^2), space complexity: O(n)
 */
public class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            if (stack.empty() || nums[i] < stack.peek()) {
                stack.push(nums[i]);
            } else {
                while (!stack.empty() && nums[i] >= stack.peek()) {
                    hm.put(stack.pop(), nums[i]);
                }
                stack.push(nums[i]);
            }
        }
        int[] res = new int[findNums.length];
        for (int i = 0; i < findNums.length; i++) {
            res[i] = hm.getOrDefault(findNums[i], -1);
        }
        return res;
    }
}
