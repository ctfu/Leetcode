/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 /* The core idea is to decide what makes a left leaf
  * 1. It needs to be in the left subtree
  * 2. It needs to be a leaf node (no children) */

public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        int res = 0;
        if (root == null) {
            return 0;
        }
        if (root.left != null) {
            if (root.left.left == null && root.left .right == null) { /* indicating it is a left leaf */
                res += root.left.val;
            }
        }
        res += sumOfLeftLeaves(root.left);
        res += sumOfLeftLeaves(root.right);
        return res;
    }
}
