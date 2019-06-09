Given a binary tree and a sum, determine if the tree has a root-to-leaf path
such that adding up all the values along the path equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

/*
time complexity: worse case O(n)
space complexity: O(logn)
*/

class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && sum == root.val) {
            return true;
        }
        return hasPathSum(root.left, sum - root.val) ||
            hasPathSum(root.right, sum - root.val);
    }
}

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
/* compare to combination sum:
 * 1. Consider a path as an array operation
 * 2. doesnot need controlling index, because a tree has left, right pointer to get the next value
 * 3. Always pick the value */
