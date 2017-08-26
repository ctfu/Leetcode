/* Approach: Level order traversal, utilizing the index techniques of building a heap
* so the width is rightMostIndex - leftMostIndex + 1 */
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> indexQueue = new LinkedList<>();
        queue.offer(root);
        indexQueue.offer(1);
        int leftMost = 0, rightMost = 0, res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode top = queue.poll();
                int index = indexQueue.poll();
                if (i == 0) {
                    leftMost = index;
                }
                if (i == size - 1) {
                    rightMost = index;
                }
                if (top.left != null) {
                    queue.offer(top.left);
                    indexQueue.offer(index * 2);
                }
                if (top.right != null) {
                    queue.offer(top.right);
                    indexQueue.offer(index * 2 + 1);
                }
            }
            res = Math.max(res, rightMost - leftMost + 1);
        }
        return res;
    }
}
