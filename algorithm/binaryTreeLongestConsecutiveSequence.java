public class Solution {
    private int max = 0;
    public int longestConsecutive(TreeNode root) {
        if(root == null) return 0;
        longest(root, root.val, 0);
        return max;
    }
    private void longest(TreeNode root, int cur, int count){
        if(root == null) return;
        if(root.val == cur){
            count++;
        }else{
            count = 1;
        }
        max = Math.max(max, count);
        longest(root.left, root.val+1, count);
        longest(root.right, root.val+1, count);
    }
}
