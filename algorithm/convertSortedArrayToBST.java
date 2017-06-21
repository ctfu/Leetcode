/* Recursive construction from the middle of the array */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;
        TreeNode root = constructTree(nums, 0, nums.length-1);
        return root;
    }
    private TreeNode constructTree(int[] nums, int begin, int end){
        if(begin > end) return null;
        int mid = begin + (end-begin)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = constructTree(nums, begin, mid-1);
        root.right = constructTree(nums, mid+1, end);
        return root;
    }
}
