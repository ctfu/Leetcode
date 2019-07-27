/*
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example 1:

Given the following tree [3,9,20,null,null,15,7]:

    3
   / \
  9  20
    /  \
   15   7
Return true.

Example 2:

Given the following tree [1,2,2,3,3,null,null,4,4]:

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
Return false.
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
