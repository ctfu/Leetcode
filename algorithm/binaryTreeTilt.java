/* A tilt of a tree node is the absolute differnet between sum of left subtree and right subtree
 * calculate the tilt of the whole tree
 * time complexity: O(n), space complexity: O(n)
 */
public class Solution {
    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return tilt(root) + findTilt(root.left) + findTilt(root.right);
    }

    public int tilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = sum(root.left);
        int right = sum(root.right);
        return Math.abs(left - right);
    }

    public int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int val = root.val;
        val += sum(root.left);
        val += sum(root.right);
        return val;
    }
}

/* simplify version
 * time complexity: O(n), space complexity: worse case O(n)
 */
 public class Solution {
    private int tilt = 0;   // global variable
    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        traverse(root);
        return tilt;
    }
    // traverse calculates sum of node valus rooted at the spcific root node
    public int traverse(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = traverse(root.left);
        int right = traverse(root.right);
        tilt += Math.abs(left - right);
        return left + right + root.val;
    }
}
