public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isLeft = true; /* indicater if the element should be added from left */
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode top = queue.poll();
                if(top.left != null) queue.offer(top.left);
                if(top.right != null) queue.offer(top.right);
                list.add(top.val);
            }
            if(!isLeft){ /* even rows, reverse the list before adding */
                Collections.reverse(list);
            }
            res.add(list);
            isLeft = !isLeft;
        }
        return res;
    }
}
