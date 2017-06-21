/* Method 1: DFS-Recursive o(k), inorder traversal k times */
public class Solution {
    private int res = 0;
    private int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inorder(root);
        return res;
    }
    private void inorder(TreeNode root){
        if(root == null) return;

        inorder(root.left);
        count--;
        if(count == 0){
            res = root.val;
            return;
        }
        inorder(root.right);
    }
}

/* Method 2: binarySearch for counting nodes, optimal time o(height), worst o(n) */
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int leftCount = inorder(root.left);
        if(k <= leftCount){
            return kthSmallest(root.left, k);
        }else if(k > leftCount + 1){
            return kthSmallest(root.right, k-leftCount-1);
        }
        return root.val;
    }
    public int inorder(TreeNode root){
        if(root == null) return 0;
        return 1 + inorder(root.left) + inorder(root.right);
    }
}
