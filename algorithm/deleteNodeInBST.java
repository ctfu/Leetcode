/* recursive soltion
 * time complexity: worse case O(logn), if delete root,
 * space complexity: worse case O(logn), recursion can deep to the leaf node
 */
public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else if (root.left != null && root.right != null) {
            TreeNode temp = findMin(root.right);
            root.val = temp.val;
            root.right = deleteNode(root.right, temp.val);
        } else {
            root = (root.left != null) ? root.left : root.right;
        }
        return root;
    }

    public TreeNode findMin(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }
        return findMin(root.left);
    }
}
