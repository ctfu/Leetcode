/* A path is defined as "Node sequence starting from any node to another node "
 * Each path has a highest node, it goes up from left up to highest and goes down right from hightst
 * Note: the tree value could be negative
 * time complexity: o(n), space complexity: O(logn) */
public class Solution {
    int maxValue = Integer.MIN_VALUE; //can initialize to 0, in case there is only one node and value is negative
    public int maxPathSum(TreeNode root) {
        findMaxPath(root);
        return maxValue;
    }
    private int findMaxPath(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, findMaxPath(node.left));
        int right = Math.max(0, findMaxPath(node.right));
        maxValue = Math.max(maxValue, left + right + node.val);
        return Math.max(left, right) + node.val;
    }
}
