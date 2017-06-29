/* Approach: Since it's a complete tree, the left tree leaf decides the tree height
 * if the whole tree height is h,
 * if right substree tree height is h - 1, then he last leaf node is in the right substree
* (which means the left substree with height h - 1 is a full tree)
 * if not, then the last leaf node is in the left substree (which means the right substree with height h - 2 is a full tree)
 * time complexity: O(log(n)^2), since each time we can decide one substree is a full tree that dont requre recursive call,
 * so the time complexity for one substree is O(log(n)), and there are log(n) of those trees
 */
public class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int h = getHeight(root);
        if (getHeight(root.right) == h - 1) {
            // 2^[(h-1) + 1] - 1 + 1
            return (1 << (h)) + countNodes(root.right);
        } else {
            // 2^[(h-2) + 1] - 1 + 1
            return (1 << (h - 1)) + countNodes(root.left);
        }

    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return getHeight(root.left) + 1;
    }
}
