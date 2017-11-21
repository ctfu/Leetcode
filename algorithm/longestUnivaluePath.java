/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 /* Approach: recursion */
class Solution {
    private int res = 0;
    public int longestUnivaluePath(TreeNode root) {
        calculate(root);
        return res;
    }

    public int calculate(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftCount = calculate(root.left);
        int rightCount = calculate(root.right);
        int left = 0, right = 0;
        if (root.left != null && root.val == root.left.val) {
            left = leftCount + 1;
        }
        if (root.right != null && root.val == root.right.val) {
            right = rightCount + 1;
        }
        res = Math.max(res, left + right);
        return Math.max(left, right);
    }
}
