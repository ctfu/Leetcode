/* seperate into left boundary, right boundary and leaves nodes */
public class Solution {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        if (root.left == null && root.right == null) {
            res.add(root.val);
            return res;
        }
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        List<Integer> leaves = new ArrayList<>();
        res.add(root.val);
        if (root.left != null) {
            leftPath(left, root.left);
        }
        findLeaf(leaves, root);
        if (root.right != null) {
            rightPath(right, root.right);
        }
        res.addAll(left);
        res.addAll(leaves);
        for (int i = right.size() - 1; i >= 0; i--) {
            res.add(right.get(i));
        }
        return res;
    }

    public void leftPath(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        // don't include the leaf node for left boundary
        if (root.left == null && root.right == null) {
            return;
        }
        res.add(root.val);
        if (root.left != null) {    // alternate between left and right tree to only include one path
            leftPath(res, root.left);
        } else {
            leftPath(res, root.right);
        }
    }

    public void rightPath(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        res.add(root.val);
        if (root.right != null) {
            rightPath(res, root.right);
        } else {
            rightPath(res, root.left);
        }
    }

    public void findLeaf(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            res.add(root.val);
        } else {
            findLeaf(res, root.left);
            findLeaf(res, root.right);
        }
    }
}
