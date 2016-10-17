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
        if(root == null){
            return true;
        }
        return height(root) != -1;
    }
    private int height(TreeNode root){
        if(root == null) return 0;
        int leftHeight = height(root.left);
        if(leftHeight == -1) return -1;
        int rightHeight = height(root.right);
        if(rightHeight == -1) return -1;
        if(leftHeight - rightHeight > 1 || leftHeight - rightHeight < -1){
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
