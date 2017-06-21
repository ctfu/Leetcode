/* The diameter of a binary tree is the longest path between any two nodes. (may not pass through root) */
public class Solution {
    private int diameter = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        findDiameter(root);
        return diameter;
    }
    public int findDiameter(TreeNode root){
        if(root == null) return -1; /* return -1, path represents edges, not level */
        int left = findDiameter(root.left);
        int right = findDiameter(root.right);
        diameter = Math.max(diameter, left+right+2);
        return Math.max(left, right) + 1;
    }
}
