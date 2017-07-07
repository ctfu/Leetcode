/* Approach: traverse the array twice to simulate circular array operation. using % operator to manipulate index
 * for each index in nums, we almost needs to travers to to index - 1, which is (index + [1...nums.length)) % nums.length
 * time complexity: O(n^2)
 */
public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if (nums.length == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = -1;
            for (int j = 1; j < nums.length; j++) {
                if (nums[(i + j) % nums.length] > nums[i]) {
                    res[i] = nums[(i + j) % nums.length];
                    break;
                }
            }
        }
        return res;
    }
}

/* traverse the array twice, push element from the end to the stack to enable nums[stack.peek()]
* becomes the next greater element
* time complexity: O(n)
*/
public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if (nums.length == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * nums.length - 1; i >= 0; i--) {
            while (!stack.empty() && nums[i % nums.length] >= nums[stack.peek()]) {
                stack.pop();
            }
            res[i % nums.length] = stack.empty() ? -1 : nums[stack.peek()];
            stack.push(i % nums.length);
        }
        return res;
    }
}
