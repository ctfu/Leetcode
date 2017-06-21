/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 /* the solution is that the height of a tree is: Max(left-subtree, right-subtree) + 1 */
public class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftDep = maxDepth(root.left);
        int rightDep = maxDepth(root.right);
        return Math.max(leftDep, rightDep) + 1;
    }
}
