Given a binary tree, each node has value 0 or 1.  Each root-to-leaf path represents a binary number
starting with the most significant bit.  For example, if the path is 0 -> 1 -> 1 -> 0 -> 1,
then this could represent 01101 in binary, which is 13.

For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.

Return the sum of these numbers.
----------------------------------------------------------------------------------------------------
/*
The key point is to understand how to transfer a binary to base 10 from right to left;
For example 101
((0*2+1)*2+0)*2+1
which means in each node, need to double the value from its parent and plus its own node value
*/
class Solution {
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int val) {
        if (root == null) return 0;
        val = val * 2 + root.val;
        if (root.left == null && root.right == null) {
            return val;
        }
        return dfs(root.left, val) + dfs(root.right, val);
    }
