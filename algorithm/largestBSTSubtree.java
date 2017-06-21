/* Use a treeNode information object to indicate the current found valid BST size,
 * and the current tree rooted at current node's min, max value range */
public class Solution {
    public int largestBSTSubtree(TreeNode root) {
        Container c = findLargest(root);
        return Math.abs(c.size);/* the root could be not valid, use Math.abs() */
    }
    public Container findLargest(TreeNode root){
        if(root == null){
            return new Container(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Container leftTree = findLargest(root.left);
        Container rightTree = findLargest(root.right);
        /* because we have flip the size to negative to indicate it is valid BST, we need to check leftTree
         * and rightTree size negativity */
        if(leftTree.size < 0 || rightTree.size < 0 ||root.val <= leftTree.max || root.val >= rightTree.min){
            int leftSize = Math.abs(leftTree.size);
            int rightSize = Math.abs(rightTree.size);
            /* Among all the cases to indicate the current rooted tree is not a BST, there could have a case
             * when the leftTree or RightTree or their substrees is a valid BST, but root is not valid, so when returning
             * we should add whichever the maximum size of the subtree */
            return new Container(Math.max(leftSize, rightSize) * -1, 0, 0);
        }else{
            /* size return should leftTree + rightTree + root, when only have one subtree root.val could <  leftTree.min*/
            return new Container(leftTree.size+rightTree.size+1, Math.min(root.val, leftTree.min), Math.max(root.val, rightTree.max));
        }
    }
    private class Container{
        int size;
        int min;
        int max;
        public Container(int size, int min, int max){
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }
}
