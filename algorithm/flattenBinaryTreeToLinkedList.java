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
     public void flatten(TreeNode root) {
         if(root == null) return;
         flatten(root.left);
         flatten(root.right);
         TreeNode left = root.left;
         TreeNode right = root.right;
         root.right = left;
         root.left = null;
         TreeNode cur = root; /* keep the reference of root */
         while(cur.right != null){
             cur = cur.right;
         }
         cur.right = right;
     }
 }

/* a variant of post-order tree traversal */
/* provide a pre node that have assume connect the previous traversal node,
   instead of returning the root, assign root the pre and return pre */
public class Solution {
    public void flatten(TreeNode root) {
        flattenHelper(root, null);
    }
    public TreeNode flattenHelper(TreeNode root, TreeNode pre){
        if(root == null) return pre;
        pre = flattenHelper(root.right, pre);/* passing current flatten result to right tree */
        pre = flattenHelper(root.left, pre); /* passing the updated result to the left tree */
        root.right = pre;
        root.left = null;
        pre = root;
        return pre; /* return the flatten result back */
    }
}
