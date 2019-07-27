/*
Given the root of a binary tree, each node in the tree has a distinct value.

After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).

Return the roots of the trees in the remaining forest.  You may return the result in any order.

Example 1:
Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
Output: [[1,2,null,4],[6],[7]]
*/
class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set = new HashSet<>();
        for (int num : to_delete) {
            set.add(num);
        }
        List<TreeNode> res = new ArrayList<>();
        buildForest(root, set, res, true);
        return res;
    }
    /*
     * 1. return boolean indicates if current tree has node deleted, which means its left and
     * right subtree are new tree
     * 2. boolean argument indicate if the current node can be potential new root */
    private boolean buildForest(TreeNode root, Set<Integer> set, List<TreeNode> list, boolean shouldAdd) {
        if (root == null) return false;
        if (set.contains(root.val)) {
            buildForest(root.left, set, list, true);
            buildForest(root.right, set, list, true);
            return true;
        }
        if (shouldAdd) {
            list.add(root);
        }
        boolean left_deleted = buildForest(root.left, set, list, false);
        boolean right_deleted = buildForest(root.right, set, list, false);
        if (left_deleted) root.left = null;
        if (right_deleted) root.right = null;
        return false;
    }
}
