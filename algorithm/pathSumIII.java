You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must
go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Example:

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11
 -------------------------------------------------------------------------------
 /* The path doesnot need to start from root and end with leaf, but it must go downwards indicates:
 1. we need to start from each node, pathSum need to Recursive
 2. does't need to the be leaf, only need root.val == sum (dont need root.left == null && root.right == null)
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
