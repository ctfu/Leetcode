/*
Given a binary tree, return the zigzag level order traversal of its nodes' values.
(ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
*/
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean rightToLeft = false; /* indicater if the element should be added from left */
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode top = queue.poll();
                if(top.left != null) queue.offer(top.left);
                if(top.right != null) queue.offer(top.right);
                list.add(top.val);
            }
            if(rightToLeft){ /* even rows, reverse the list before adding */
                Collections.reverse(list);
            }
            res.add(list);
            rightToLeft = !rightToLeft;
        }
        return res;
    }
}
