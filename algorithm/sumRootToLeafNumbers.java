Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

Note: A leaf is a node with no children.

Example:

Input: [1,2,3]
    1
   / \
  2   3
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.
--------------------------------------------------------------------------------
//The key is to understand how to calculate a number from right to left
class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        return sumPath(root, 0); // zero represets the total sum from its parents
    }

    private int sumPath(TreeNode root, int val) {
        if (root == null) return 0;
        val = val * 10 + root.val;
        if (root.left == null && root.right == null) {
            return val;
        }
        return sumPath(root.left, val) + sumPath(root.right, val);
    }
}
