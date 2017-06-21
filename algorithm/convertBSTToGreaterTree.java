/* Requirement: convert each node value to the current value + sum of all other value greater than current value */
/* Approach: Modified recursive traversal, right->root->left */
public class Solution {
    private int sum = 0;    /* use a global variable to keep track of the accumulated sum */
    public TreeNode convertBST(TreeNode root) {
        convertTree(root);
        return root;
    }
    public void convertTree(TreeNode root){
        if(root == null) return;
        convertTree(root.right);
        sum += root.val;
        root.val = sum;
        convertTree(root.left);
    }
}
