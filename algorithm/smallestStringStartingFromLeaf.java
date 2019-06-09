Given the root of a binary tree, each node has a value from 0 to 25 representing
 the letters 'a' to 'z': a value of 0 represents 'a', a value of 1 represents 'b', and so on.

Find the lexicographically smallest string that starts at a leaf of this tree and ends at the root.

(As a reminder, any shorter prefix of a string is lexicographically smaller:
for example, "ab" is lexicographically smaller than "aba".  A leaf of a node is a node that has no children.)

--------------------------------------------------------------------------------
class Solution {
    String ans = "~"; // this guarrantee to be greater than any string can get from the tree
    public String smallestFromLeaf(TreeNode root) {
        if (root == null) return "";
        findSmallLeaf(root, "");
        return ans;
    }

    private void findSmallLeaf(TreeNode root, String s) {
        if (root == null) return;
        // (char) 'a' + root.val: help solve transfrom 0-25 to a-z
        // (char)('a' + root.val) + s: add the string in reverse order
        s = (char)('a' + root.val) + s;
        if (root.left == null && root.right == null) {
            if (s.compareTo(ans) < 0) {
                ans = s;
            }
        }
        findSmallLeaf(root.left, s);
        findSmallLeaf(root.right, s);
    }
}
