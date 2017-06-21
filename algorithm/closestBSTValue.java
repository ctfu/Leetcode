public class Solution {
    public int closestValue(TreeNode root, double target) {
        TreeNode close = findClosestValue(root, target);
        return close.val;
    }
    public TreeNode findClosestValue(TreeNode root, double target){
        if(root == null) return null;
        TreeNode left = findClosestValue(root.left, target);
        TreeNode right = findClosestValue(root.right, target);
        TreeNode close = root;
        if(left != null && right != null){
            TreeNode cl1 = Math.abs(root.val - target) < Math.abs(left.val-target) ? root : left;
            close = Math.abs(cl1.val-target) < Math.abs(right.val-target) ? cl1 : right;
        }else if(left != null){
            close = Math.abs(root.val - target) < Math.abs(left.val-target) ? root : left;
        }else if(right != null){
            close = Math.abs(root.val - target) < Math.abs(right.val-target) ? root : right;
        }
        return close;
    }
}

/* imporove version, similar to BST search, change to search absolute difference */
public class Solution {
    public int closestValue(TreeNode root, double target) {
        int res = root.val; /* set a start res */
        while(root != null){
            if(Math.abs(target - root.val) < Math.abs(target-res)){
                res = root.val;
            }
            root = root.val > target ? root.left : root.right;
        }
        return res;
    }
}
