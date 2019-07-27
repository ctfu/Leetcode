/*
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its minimum depth = 2.
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
