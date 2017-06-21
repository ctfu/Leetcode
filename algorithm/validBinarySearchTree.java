
 /* Assume a BST is defined as follows:

  * 1. The left subtree of a node contains only nodes with keys less than the node's key.
  * 2. The right subtree of a node contains only nodes with keys greater than the node's key.
  * 3. Both the left and right subtrees must also be binary search trees. */

 /* Approach: define a [min, max] that the current node value should fit it */
 /* head recursion: deal with left subtree and right substree first, and then deal with root node */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        Container c = validBSTHelper(root);
        return c.isBST;
    }
    public Container validBSTHelper(TreeNode root){
        if(root == null) return new Container(true, Long.MAX_VALUE, Long.MIN_VALUE);/* give a value to start */
        Container left = validBSTHelper(root.left);
        Container right = validBSTHelper(root.right);
        /* the cases when current rooted tree is not BST */
        if(!left.isBST || !right.isBST || root.val <= left.max || root.val >= right.min){
            return new Container(false, 0, 0);
        }else{
            return new Container(true, (long)Math.min((long)root.val, left.min), (long)Math.max((long)root.val, right.max));
        }
    }
    private class Container{
        boolean isBST;
        long min;
        long max;
        public Container(boolean isBST, long min, long max){
            this.isBST = isBST;
            this.min = min;
            this.max = max;
        }
    }
}

/* second recursion, tail recrusion */
/* strategy: deal with root node, and then recursively deal with left subtree and right substree */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean isValidBST(TreeNode root, long min, long max){
        if(root == null) return true;
        if(root.val <= min || root.val >= max) return false;
        return isValidBST(root.left, min, (long)root.val) && isValidBST(root.right, (long)root.val, max);
    }
}
