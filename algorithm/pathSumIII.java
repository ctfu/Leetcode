/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 /* The path doesnot need to start from root and end with leaf, but it must go downwards*/
 /* Time complexity: O(nlogn) if balanced binary Tree
  * o(n^2) if the tree is a LinkedList like structure */
public class Solution {
    public int pathSum(TreeNode root, int sum) {
        if(root == null){
            return 0;
        }
        /* start with each node to find a path */
        return findPath(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    public int findPath(TreeNode root, int sum){
        int res = 0;
        if(root == null){
            return res;
        }
        if(sum == root.val){
            res++;
        }
        /* reason not put else, there could exist a path as 1->-2->1->-1, sum = -1
         * if we stop at 1->-2, we will miss the path above */
        res += findPath(root.left, sum-root.val);
        res += findPath(root.right, sum-root.val);
        return res;
    }
}
