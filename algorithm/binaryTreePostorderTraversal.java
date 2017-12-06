/* non-recursive, utilize a nodecontainer with a flag to indicate whether a nodes
* has been visited or not. If a node has been visited twice, then the node should
* should remove from the stack */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<NodeContainer> stack = new Stack<>();
        TreeNode current = root;
        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                NodeContainer nc = new NodeContainer(false, current);
                stack.push(nc);
                current = current.left;
            }
            NodeContainer nc = stack.pop();
            TreeNode node = nc.node;
            if (!nc.visited) {
                nc.visited = true;
                stack.push(nc);
                current = node.right;
            } else {
                res.add(node.val);
            }
        }
        return res;
    }

    class NodeContainer {
        boolean visited;
        TreeNode node;

        public NodeContainer(boolean visited, TreeNode node) {
            this.visited = visited;
            this.node = node;
        }
    }
}
