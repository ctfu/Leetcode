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
        Set<Integer> set = new HashSet<>();
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        List<Integer> leaves = new ArrayList<>();
        res.add(root.val);
        set.add(root.val);
        if (root.left != null) {
            leftPath(left, root.left, set);
        }
        findLeaf(leaves, root, set);
        if (root.right != null) {
            rightPath(right, root.right, set);
        }
        res.addAll(left);
        res.addAll(leaves);
        for (int i = right.size() - 1; i >= 0; i--) {
            res.add(right.get(i));
        }
        return res;
    }

    public void leftPath(List<Integer> res, TreeNode root, Set<Integer> set) {
        if (root == null) {
            return;
        }
        if (!set.contains(root.val)) {
            res.add(root.val);
            set.add(root.val);
        }
        if (root.left == null && root.right == null) {
            return;
        }
        if (root.left != null) {
            leftPath(res, root.left, set);
        } else {
            leftPath(res, root.right, set);
        }
    }

    public void rightPath(List<Integer> res, TreeNode root, Set<Integer> set) {
        if (root == null) {
            return;
        }
        if (!set.contains(root.val)) {
            res.add(root.val);
            set.add(root.val);
        }
        if (root.left == null && root.right == null) {
            return;
        }
        if (root.right != null) {
            rightPath(res, root.right, set);
        } else {
            rightPath(res, root.left, set);
        }
    }

    public void findLeaf(List<Integer> res, TreeNode root, Set<Integer> set) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (!set.contains(root.val)) {
                res.add(root.val);
                set.add(root.val);
            }
        } else {
            findLeaf(res, root.left, set);
            findLeaf(res, root.right, set);
        }
    }
}
