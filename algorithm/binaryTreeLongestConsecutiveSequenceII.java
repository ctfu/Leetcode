/* time complexity: O(n), space complexity: worse case O(n), average O(logn)
 */
public class Solution {
    private int maxLen; // not necessary to start from root, use global variable to store while processing subtrees
    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        longestPath(root);
        return maxLen;
    }
    // a method return a paire int[] p, with p[0] store the longestPath in increasing order, p[1] store longest path decreasing order
    public int[] longestPath(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int incr = 1, decr = 1; // single node sequence is 1, (importnat)
        int[] l = longestPath(root.left);
        int[] r = longestPath(root.right);
        if (root.left != null) {
            if (root.val == root.left.val + 1) {
                decr = l[1] + 1;
            } else if (root.val == root.left.val - 1) {
                incr = l[0] + 1;
            }
        }
        if (root.right != null) {
            if (root.val == root.right.val + 1) {
                decr = Math.max(decr, r[1] + 1);
            } else if (root.val == root.right.val - 1) {
                incr = Math.max(incr, r[0] + 1);
            }
        }
        maxLen = Math.max(maxLen, incr + decr - 1);
        return new int[]{incr, decr};
    }
}
