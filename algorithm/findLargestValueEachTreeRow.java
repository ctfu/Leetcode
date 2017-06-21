/* Level order traversal, BFS, time: O(n), space: O(n)*/
public class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int max = Integer.MIN_VALUE;    /* a max to store the max for each row */
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode top = queue.poll();
                max = Math.max(max, top.val);
                if(top.left != null) queue.offer(top.left);
                if(top.right != null) queue.offer(top.right);
            }
            res.add(max);
        }
        return res;
    }
}

/* DFS  time: O(n), space: O(logn)*/
public class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        findLargest(res, root, 0);
        return res;
    }
    private void findLargest(List<Integer> res, TreeNode root, int curLevel){
        if(root == null) return;
        if(res.size() == curLevel){
            res.add(root.val);
        }else{
            res.set(curLevel, Math.max(res.get(curLevel), root.val));
        }
        findLargest(res, root.left, curLevel + 1);
        findLargest(res, root.right, curLevel + 1);
    }
}
