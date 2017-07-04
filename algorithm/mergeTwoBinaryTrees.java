/* Approach: recursive
 * time complexity: O(n), space complexity: O(n), n is the minimum number of nodes of two trees
 */
 public class Solution {
     public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
         if (t1 == null) {
             return t2;
         }
         if (t2 == null) {
             return t1;
         }
         t1.val += t2.val;  // dont need to create a new node, just accumulate sum to t1
         t1.left = mergeTrees(t1.left, t2.left);
         t1.right = mergeTrees(t1.right, t2.right);
         return t1;
     }
 }
