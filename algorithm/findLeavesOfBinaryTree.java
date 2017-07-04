/* Approach one: repeatly collect the leaf nodes, and delete them at the same time
 * time complexity: worse case O(nlogn), logn height of tree, each time O(n) to collect leafs nodes
 */
public class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        // while there is anymore subtrees
        while (root.left != null || root.right != null) {
            List<Integer> tempList = new ArrayList<>();
            collect(root, tempList);
            res.add(tempList);
        }
        res.add(Arrays.asList(root.val));   // add the root value at the end
        return res;
    }
    // a method to collect all current leaves nodes, and delete the leave nodes
    public void collect(TreeNode root, List<Integer> tempList) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                tempList.add(root.left.val);
                root.left = null;
            } else {
                collect(root.left, tempList);
            }
        }
        if (root.right != null) {
            if (root.right.left == null && root.right.right == null) {
                tempList.add(root.right.val);
                root.right = null;
            } else {
                collect(root.right, tempList);
            }
        }
    }
}

/* Second Approach: new angle, by calculating the height of each node, because each leaf node will have the same height of a tree
 * time complexity: O(n), traverse each node, space complexity: O(n^2)
 */
 public class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        collectByHeight(res, root);
        return res;
    }
    // a method calculates the height while collecting its leaves nodes
    public int collectByHeight(List<List<Integer>> res, TreeNode root) {
        if (root == null) {
            return -1;
        }
        // calculating the height of current root node
        int height = Math.max(collectByHeight(res, root.left), collectByHeight(res, root.right)) + 1;
        if (res.size() < height + 1) {  // each height level is associate with one arraylist starting from 0-hegiht
            res.add(new ArrayList<>());
        }
        res.get(height).add(root.val);  //add the current node to its associate level arraylist
        return height;
    }
}
