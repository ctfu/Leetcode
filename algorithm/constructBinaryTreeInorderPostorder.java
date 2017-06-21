/* Same approach as construct binary tree preorder inorder */
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0 || postorder.length == 0 || inorder.length != postorder.length){
            return null;
        }
        int val = postorder[postorder.length-1];
        TreeNode root = new TreeNode(val);
        int i;
        for(i = 0; i < inorder.length; i++){
            if(inorder[i] == val){
                break;
            }
        }
        root.left = buildTree(Arrays.copyOfRange(inorder, 0, i), Arrays.copyOfRange(postorder, 0, i));
        root.right = buildTree(Arrays.copyOfRange(inorder, i+1, inorder.length),
                                                        Arrays.copyOfRange(postorder, i, postorder.length-1));
        return root;
    }
}
