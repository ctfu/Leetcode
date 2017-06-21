/* 1. Get the node values by inorder traversal
 * 2. Find smallest difference, o(n) time, o(n) space*/
public class Solution {
    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        int diff = Integer.MAX_VALUE;
        for(int i = 1; i < list.size(); i++){
            if((list.get(i)-list.get(i-1)) < diff){
                diff = list.get(i)-list.get(i-1);
            }
        }
        return diff;
    }
    public void inorder(TreeNode root, List<Integer> list){
        if(root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}

/* O(n) complexity, O(1) space */
public class Solution {
    private int min = Integer.MAX_VALUE;
    private TreeNode pre = null;       /* using pre to record the previous value */
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return min;
    }
    public void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        if(pre != null){
            min = Math.min(min, root.val-pre.val);
        }
        pre = root;
        inorder(root.right);
    }
}
