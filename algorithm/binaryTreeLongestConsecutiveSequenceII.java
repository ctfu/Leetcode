/*
Given a binary tree, you need to find the length of Longest Consecutive Path in
Binary Tree. Especially, this path can be either increasing or decreasing. For example,
[1,2,3,4] and [4,3,2,1] are both considered valid, but the path [1,2,4,3] is not
valid. On the other hand, the path can be in the child-Parent-child order, where
not necessarily be parent-child order.

Example 1:

Input:
        1
       / \
      2   3
Output: 2
Explanation: The longest consecutive path is [1, 2] or [2, 1].


Example 2:

Input:
        2
       / \
      1   3
Output: 3
Explanation: The longest consecutive path is [1, 2, 3] or [3, 2, 1].
*/
/* time complexity: O(n), space complexity: worse case O(n), average O(logn)
 */
public class Solution {
    private int maxLen; // not necessary to start from root, use global variable to store while processing subtrees
    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        longestPath(root);
        return maxLen;
    }
    // a method return a paire int[] p, with 
    // p[0] store the longestPath in increasing order,
    // p[1] store longest path decreasing order
    public int[] longestPath(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int incr = 1, decr = 1; // single node sequence is 1, (importnat)
        int[] l = longestPath(root.left);
        int[] r = longestPath(root.right);
        if (root.left != null) {
            if (root.val == root.left.val + 1) {
                decr = l[1] + 1;
            } else if (root.val == root.left.val - 1) {
                incr = l[0] + 1;
            }
        }
        if (root.right != null) {
            if (root.val == root.right.val + 1) {
                decr = Math.max(decr, r[1] + 1);
            } else if (root.val == root.right.val - 1) {
                incr = Math.max(incr, r[0] + 1);
            }
        }
        maxLen = Math.max(maxLen, incr + decr - 1);
        return new int[]{incr, decr};
    }
}
