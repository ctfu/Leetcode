/* Approach: recursive buildTree by separating the preorder and inorder list into left and right tree
 * based on the root index */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0 || preorder.length != inorder.length){
            return null;
        }
        int val = preorder[0];
        TreeNode root = new TreeNode(val);
        int i;
        for(i = 0; i < inorder.length; i++){
            if(inorder[i] == val){
                break;
            }
        }
        /* using Arrays.copyOfRange(source, start, end) to copy subArray */
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, i+1), Arrays.copyOfRange(inorder, 0, i));
        root.right = buildTree(Arrays.copyOfRange(preorder, i+1, preorder.length),
                                                Arrays.copyOfRange(inorder, i+1, inorder.length));
        return root;
    }
}
/* An improved approach without copying, but manipulate index positions */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0 || preorder.length != inorder.length){
            return null;
        }
        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }
        /* remember here use argument index */
        int val = preorder[preStart];
        TreeNode root = new TreeNode(val);
        int i;
        for(i = inStart; i < inEnd; i++){
            if(inorder[i] == val){
                break;
            }
        }
        root.left = buildTree(preorder, preStart+1, preStart+(i-inStart), inorder, inStart, i-1);
        root.right = buildTree(preorder, preStart+(i-inStart)+1, preEnd, inorder, i+1, inEnd);
        return root;
    }
}
