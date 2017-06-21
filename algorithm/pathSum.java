/* A path is found when root.left == null && root.right == null */
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

/* tail recursive solution */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        /* when sum == 0, also check if is the end of a path */
        if((sum-root.val) == 0 && root.left == null && root.right == null) return true;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}

/* compare to combination sum:
 * 1. Consider a path as an array operation
 * 2. doesnot need controlling index, because a tree has left, right pointer to get the next value
 * 3. Always pick the value */
