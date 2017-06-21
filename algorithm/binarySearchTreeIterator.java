/* Idea: start from the left most node, repeatly find that node's successor */
public class BSTIterator {
    private TreeNode root;
    private TreeNode start; /* starting node of inorder traversal */

    public BSTIterator(TreeNode root) {
        this.root = root;
        TreeNode cur = root;
        while(cur != null && cur.left != null){
            cur = cur.left;
        }
        start = cur;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return start != null;
    }

    /** @return the next smallest number */
    /* operates in o(h) time */
    public int next() {
        int val = start.val;
        start = successor(root, start); /* get the successor of start node */
        return val;
    }

    public TreeNode successor(TreeNode root, TreeNode p){
        if(root == null) return null;
        if(p.val >= root.val){
            return successor(root.right, p);
        }else{
            TreeNode left = successor(root.left, p);
            return left == null ? root : left;
        }
    }
}
