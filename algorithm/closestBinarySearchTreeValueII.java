/* Approach: the k near value can be obtain by the near predecessor and successor from the target
 * inorder search BST gives a sorted values: before target -> stack for predecessor, after target -> queue for near successor
 * time complexity: O(n), space complexity O(n)
 * using two stack with early termination can be a little faster
 */
public class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        inorder(root, target, stack, queue);
        while (res.size() < k) {
            if (stack.empty()) {
                res.add(queue.poll());
            } else if (queue.isEmpty()) {
                res.add(stack.pop());
            } else if (Math.abs(target - stack.peek()) < Math.abs(target - queue.peek())) {
                res.add(stack.pop());
            } else {
                res.add(queue.poll());
            }
        }
        return res;
    }

    public void inorder(TreeNode root, double target, Stack<Integer> stack, Queue<Integer> queue) {
        if (root == null) {
            return;
        }
        inorder(root.left, target, stack, queue);
        if (root.val <= target) {
            stack.push(root.val);
        } else {
            queue.offer(root.val);
        }
        inorder(root.right, target, stack, queue);
    }
}
