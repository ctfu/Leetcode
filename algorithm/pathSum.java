/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        List<Integer> pathSum = new ArrayList<>();
        searchPath(root, pathSum, 0);
        return pathSum.contains(sum);
    }
    private void searchPath(TreeNode root, List<Integer> pathSum, int sum){
        if(root == null){
            return;
        }
        sum += root.val;
        searchPath(root.left, pathSum, sum);
        searchPath(root.right, pathSum, sum);
        if(root.left == null && root.right == null){
            pathSum.add(sum);
        }
    }
}

// a better Solution
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if((sum-root.val) == 0 && root.left == null && root.right == null) return true;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
