/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 /* definition of minimum depth: number of node along the shortest path to the leaf */
public class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        if(leftDepth == 0) return rightDepth + 1; /* avoid single substree problem */
        else if(rightDepth == 0) return leftDepth + 1;
        else return leftDepth > rightDepth ? rightDepth + 1 : leftDepth + 1;
    }
}
