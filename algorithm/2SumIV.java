Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

Example 1:

Input:
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True


Example 2:

Input:
    5
   / \
  3   6
 / \   \
2   4   7
--------------------------------------------------------------------------------
/*  1. if the input is a BST, it can still use the hashmap method, the difference is to search through
    a tree intead of an array
    2. another approach would be to inorder search the bst tree to get an sorted list, then use
    two pointer solution */
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();//should replace to hashSet since only need to store one element
        if (find(root, k, map)) {
            return true;
        }
        return false;
    }

    public boolean find(TreeNode root, int k, Map<Integer, Integer> map) {
        if (root == null) {
            return false;
        }
        if (map.containsKey(k - root.val)) {
            return true;
        }
        map.put(root.val, root.val);
        return find(root.left, k, map) || find(root.right, k, map);
    }
}
