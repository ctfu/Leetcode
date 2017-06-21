/* 1. if p.val >= root.val, p in right substree, the successor will always in the right substree
 * 2. otherwise, p in left substree, the successor will either be in left substree or current root */
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null) return null;
        if(p.val >= root.val){
            return inorderSuccessor(root.right, p);
        }else{
            TreeNode left = inorderSuccessor(root.left, p);
            return left == null ? root : left;
        }
    }
}

/* inorder predecessor is similar */
public TreeNode inorderPredecessor(TreeNode root, TreeNode p){
    if(root == null) return null;
    if(p.val > root.val){
        TreeNode right = inorderPredecessor(root.right, p);
        return right == null ? root : right;
    }else{
        return inorderPredecessor(root.left);
    }
}
