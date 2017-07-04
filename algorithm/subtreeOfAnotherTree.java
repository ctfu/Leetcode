/* time complexity: O(m * n), m is the total nodes in s, n is the total nodes in t
 * space complexity: O(m), the recursion depth can go down to depth m, n is number of nodes in s
 */
public class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        if (checkSubtree(s, t)) {
            return true;
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
