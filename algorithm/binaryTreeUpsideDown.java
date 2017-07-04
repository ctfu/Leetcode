/* From question, we know that:
 * 1. if there is a right node, there must be a left node, so we only need to check left node
 * 2. flip the tree, by changing the each left node's left and right substree nodes
 * time complexity: O(logn), only recursive the left subtree, space complexity: O(logn)
 */
public class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null) {
            return root;
        }
        TreeNode newNode = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return newNode;
    }
}
