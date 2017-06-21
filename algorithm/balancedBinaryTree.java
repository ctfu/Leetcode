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
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        if(isBalanced(root.left) && isBalanced(root.right)){
            int leftHeight = getHeight(root.left);
            int rightHeight = getHeight(root.right);
            if(Math.abs(leftHeight - rightHeight) < 2){
                return true;
            }
        }
        return false;
    }
    private int getHeight(TreeNode root){
        if(root == null) return 0;
        int lh = getHeight(root.left);
        int rh = getHeight(root.right);
        return Math.max(lh, rh) + 1;
    }
}

/* better solution */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        return getHeight(root) != -1;
    }
    /* a slide midification on top of getHeight */
    private int getHeight(TreeNode root){
        if(root == null) return 0;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        /* if left tree and right tree height is differ more than 1, use -1 to indicate unbalanced */
        if(rightHeight == -1 || leftHeight == -1 || Math.abs(leftHeight - rightHeight) > 1){
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
