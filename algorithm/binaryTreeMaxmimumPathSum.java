Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some
starting node to any node in the tree along the parent-child connections.
The path must contain at least one node and does not need to go through the root.

Example 1:

Input: [1,2,3]

       1
      / \
     2   3

Output: 6
Example 2:

Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42
/* A path is defined as "Node sequence starting from any node to another node "
 * Each path has a highest node, it goes up from left up to highest and goes down right from hightst
 * Note: the tree value could be negative value
 * time complexity: o(n), space complexity: O(logn) */
public class Solution {
    int maxValue = Integer.MIN_VALUE; //can initialize to 0, in case there is only one node and value is negative
    public int maxPathSum(TreeNode root) {
        findMaxPath(root);
        return maxValue;
    }
    private int findMaxPath(TreeNode node) {
        if (node == null) return 0;
        // the below 3 lines solve the problem of max of left + root, root + right, left + right + root
        int left = Math.max(0, findMaxPath(node.left));
        int right = Math.max(0, findMaxPath(node.right));
        maxValue = Math.max(maxValue, left + right + node.val);
        return Math.max(left, right) + node.val;
    }
}
