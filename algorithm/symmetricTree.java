Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
 -------------------------------------------------------------------------------
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
    public boolean isSymmetric(TreeNode root) {
      if(root == null) return true;
      return isMirror(root.left, root.right);
    }
    private boolean isMirror(TreeNode left, TreeNode right){
        /* deal with different symmetric conditions */
        if(left == null && right == null){
            return true;
        }else if(left == null || right == null){
            return false;
        }else{
            return left.val == right.val && isMirror(left.left, right.right) && isMirror(left.right, right.left);
        }
    }
}
// interative Solution
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode first = queue.poll();
            TreeNode second = queue.poll();
            // here uses continue, their could be two null leaf nodes
            if (first == null && second == null) continue;  
            if (first == null || second == null) return false;
            if (first.val != second.val) return false;
            queue.offer(first.left);
            queue.offer(second.right);
            queue.offer(first.right);
            queue.offer(second.left);
        }
        return true;
    }
}
