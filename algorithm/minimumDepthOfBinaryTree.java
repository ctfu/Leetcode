/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        if(leftDepth == 0) return rightDepth == 0 ? 1 : rightDepth + 1;
        else if(rightDepth == 0) return leftDepth == 0 ? 1 :leftDepth + 1;
        else return leftDepth > rightDepth ? rightDepth + 1 : leftDepth + 1;
    }
}
