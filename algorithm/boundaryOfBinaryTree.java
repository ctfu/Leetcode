/* Acepted solution from leetcode */
public class Solution {

    public boolean isLeaf(TreeNode t) {
        return t.left == null && t.right == null;
    }

    public void addLeaves(List<Integer> res, TreeNode root) {
        if (isLeaf(root)) {
            res.add(root.val);
        } else {
            if (root.left != null) {
                addLeaves(res, root.left);
            }
            if (root.right != null) {
                addLeaves(res, root.right);
            }
        }
    }

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        if (!isLeaf(root)) {
            res.add(root.val);
        }
        TreeNode t = root.left;
        while (t != null) {
            if (!isLeaf(t)) {
                res.add(t.val);
            }
            if (t.left != null) {
                t = t.left;
            } else {
                t = t.right;
            }

        }
        addLeaves(res, root);
        Stack<Integer> s = new Stack<>();
        t = root.right;
        while (t != null) {
            if (!isLeaf(t)) {
                s.push(t.val);
            }
            if (t.right != null) {
                t = t.right;
            } else {
                t = t.left;
            }
        }
        while (!s.empty()) {
            res.add(s.pop());
        }
        return res;
    }
}

/* This is my solution */
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
        if (root.left == null && root.right == null) {
            return;
        }
        res.add(root.val);
        if (root.left != null) {
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
