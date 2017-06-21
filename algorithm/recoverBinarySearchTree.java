/* If accidently swap two values of a BST, constant space recover the tree */
/* Using in-order traversal, but space is O(h) */
public class Solution {
    private TreeNode first = null;  /* swap node 1 */
    private TreeNode second = null; /* swap node 2 */
    private TreeNode pre = null;
    private boolean firstTime = true;/* detect first abnormal inorder value */
    public void recoverTree(TreeNode root) {
        pre = new TreeNode(Integer.MIN_VALUE);
        inorder(root);
        if(first != null && second != null){
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }
    private void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        if(root.val < pre.val && firstTime){
            first = pre;
            firstTime = false;
        }
        if(root.val < pre.val && !firstTime){
            second = root;
        }
        pre = root;
        inorder(root.right);
    }
}

/* Morris traversal: constant space */
public class Solution {
    public void recoverTree(TreeNode root) {
        TreeNode first = null;
        TreeNode second = null;
        TreeNode pre = new TreeNode(Integer.MIN_VALUE);
        boolean firstTime = true;

        while(root != null){
            if(root.left != null){
                TreeNode temp = root.left;
                while(temp.right != null && temp.right != root){
                    temp = temp.right;
                }
                if(temp.right == null){
                    temp.right = root;
                    root = root.left;
                }else{
                    temp.right = null;
                    if(root.val < pre.val && firstTime){
                        first = pre;
                        firstTime = false;
                    }
                    if(root.val < pre.val && !firstTime){
                        second = root;
                    }
                    pre = root;
                    root = root.right;
                }
            }else{
                if(root.val < pre.val && firstTime){
                    first = pre;
                    firstTime = false;
                }
                if(root.val < pre.val && !firstTime){
                    second = root;
                }
                pre = root;
                root = root.right;
            }
        }
        if(first != null && second != null){
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }
}
