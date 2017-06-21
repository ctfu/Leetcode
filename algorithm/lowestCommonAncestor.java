/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root == p || root == q) return root;/* root is the lowest common ancestor */
        TreeNode isLeft = lowestCommonAncestor(root.left, p, q);
        TreeNode isRight = lowestCommonAncestor(root.right, p, q);
        if(isLeft != null && isRight != null){ /* p, q in different subtree */
            return root;
        }else if(isLeft != null){ /* p,q in left tree */
            return isLeft;
        }else{
            return isRight; /* p, q in right tree */
        }
    }
}

/* iterative solution */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parent = new HashMap<>(); /* hashmap to store node's parent */
        Deque<TreeNode> stack = new ArrayDeque<>();/*can use a queue here */
        parent.put(root, null);
        stack.push(root);

        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }
        /* check where there ancestor meets */
        Set<TreeNode> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }
        while (!ancestors.contains(q))
            q = parent.get(q);
        return q;
    }
}
