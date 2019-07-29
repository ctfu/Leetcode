/*
Given a binary tree, return the tilt of the whole tree.

The tilt of a tree node is defined as the absolute difference between the
sum of all left subtree node values and the sum of all right subtree node values.
Null node has tilt 0.

The tilt of the whole tree is defined as the sum of all nodes' tilt.

Example:
Input:
         1
       /   \
      2     3
Output: 1
Explanation:
Tilt of node 2 : 0
Tilt of node 3 : 0
Tilt of node 1 : |2-3| = 1
Tilt of binary tree : 0 + 0 + 1 = 1
*/
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
