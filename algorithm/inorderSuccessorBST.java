/*
Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
The successor of a node p is the node with the smallest key greater than p.val.
*/
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
