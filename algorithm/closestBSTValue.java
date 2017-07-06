/* Approach 1: take advantage of inorder sorted order search, using global variable to trace the difference
 * time complexity: O(n), space complexity: O(1)
 */
public class Solution {
    private double diff;
    private int closest = 0;
    public int closestValue(TreeNode root, double target) {
        diff = Math.abs(target - root.val);
        inorder(root, target);
        return closest;
    }

    public void inorder(TreeNode root, double target) {
        if (root == null) {
            return;
        }
        inorder(root.left, target);
        // note that Math.abs() takes int, return int, takes double, return double
        double difference = Math.abs(root.val - target);
        if (difference <= diff) {
            closest = root.val;
            diff = difference;
        }
        inorder(root.right, target);
    }
}

/* imporove version, similar to BST search, change to search absolute difference */
public class Solution {
    public int closestValue(TreeNode root, double target) {
        int res = root.val; /* set a start res */
        while(root != null){
            if(Math.abs(target - root.val) < Math.abs(target-res)){
                res = root.val;
            }
            root = root.val > target ? root.left : root.right;
        }
        return res;
    }
}
