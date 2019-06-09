Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.

Example 1:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
Given tree t:
   4
  / \
 1   2
Return true, because t has the same structure and node values with a subtree of s.
Example 2:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
    /
   0
Given tree t:
   4
  / \
 1   2
Return false.
--------------------------------------------------------------------------------

/* time complexity: O(m), m is the total nodes in s, n is the total nodes in t
 * space complexity: O(m), the recursion depth can go down to depth m, n is number of nodes in s
 */
public class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        // if same value, we found a possible substree, should check it. can't simple
        // return checkSubtree because tree nodes in s may have same value
        if (s.val == t.val) {
            if (checkSubtree(s, t)) {
                return true;
            }
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public boolean checkSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        return s.val == t.val && checkSubtree(s.left, t.left) && checkSubtree(s.right, t.right);
    }
}
