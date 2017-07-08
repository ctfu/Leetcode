/* Based on the idea that a binary tree in-degree == out-degree
* A non-null node has 1 in degree 2 outdegree (except root)
* A null node has 1 in-degree
* In pre-order, the diff = out-degree - indegree will never less than 0
*/
public class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int diff = 1;   // added for considering the root has one in-degree
        for (String n : nodes) {
            if (--diff < 0) {
                return false;
            }
            if (!n.equals("#")) {
                diff += 2;
            }
        }
        return diff == 0;
    }
}

/* approach 2: Using stack */
public class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        Stack<String> stack = new Stack<>();
        for (String node : nodes) {
            while (node.equals("#") && !stack.empty() && stack.peek().equals("#")) {
                stack.pop(); // pop "#"
                if (stack.empty()) {
                    return false;
                }
                stack.pop();    // pop the root of current tree 
            }
            stack.push(node);
        }
        return stack.size() == 1 && stack.peek().equals("#");
    }
}
