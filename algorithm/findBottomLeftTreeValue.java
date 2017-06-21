/* Level order Traversal + store each first left node at each level */
public class Solution {
    public int findBottomLeftValue(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode top = queue.poll();
                if(i == 0) res = top.val; /* first left node */
                if(top.left != null) queue.offer(top.left);
                if(top.right != null) queue.offer(top.right);
            }
        }
        return res;
    }
}
