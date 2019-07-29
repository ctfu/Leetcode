/*
Given a binary tree, find the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to any node
in the tree along the parent-child connections. The longest consecutive path
need to be from parent to child (cannot be the reverse).

Example 1:

Input:

   1
    \
     3
    / \
   2   4
        \
         5

Output: 3

Explanation: Longest consecutive sequence path is 3-4-5, so return 3.
Example 2:

Input:

   2
    \
     3
    /
   2
  /
 1

Output: 2

Explanation: Longest consecutive sequence path is 2-3, not 3-2-1, so return 2.
*/
// Note: here the longest consecutive sequence path is increasing path
public class Solution {
    private int max = 0;
    public int longestConsecutive(TreeNode root) {
        if(root == null) return 0;
        longest(root, root.val, 0);
        return max;
    }
    private void longest(TreeNode root, int cur, int count){
        if(root == null) return;
        if(root.val == cur){
            count++;
        }else{
            count = 1;
        }
        max = Math.max(max, count);
        longest(root.left, root.val+1, count);
        longest(root.right, root.val+1, count);
    }
}
