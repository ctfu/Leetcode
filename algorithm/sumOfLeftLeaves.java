/*
3
/ \
9  20
/  \
15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.

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
