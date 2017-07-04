/* Approach: stack, once in the right subtree node, where preorder[i] > stack.peek(), pop all previous left subtree nodes
 * and store pop value as a lower bound, since right subtree value should always bigger than left tree node values
 * time complexity worse case: O(n^2), if the tree is skew to one side
 * space complexity: O(n)
 */
public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        if (preorder.length == 0) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        int lowBound = Integer.MIN_VALUE;
        for (int i = 0; i < preorder.length; i++) {
            if (preorder[i] < lowBound) {
                return false;
            }
            while (!stack.empty() && preorder[i] > stack.peek()) {
                lowBound = stack.pop();
            }
            stack.push(preorder[i]);
        }
        return true;
    }
}

/* improve to O(1) extra space by modifying the value in preorder */
public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        if (preorder.length == 0) {
            return true;
        }
        int lowBound = Integer.MIN_VALUE;
        int i = -1;
        // I think here doesn't cause concurrent modification exception is because only elements before
        // p is modified and total length is unchanged
        for (int p : preorder) {
            if (p < lowBound) {
                return false;
            }
            while (i >= 0 && p > preorder[i]) {
                lowBound = preorder[i--];
            }
            preorder[++i] = p;
        }
        return true;
    }
}
