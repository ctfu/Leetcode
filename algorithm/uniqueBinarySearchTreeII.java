/* recursively construct the binary seach tree */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<TreeNode>();
        return genTrees(1, n);
    }
    private List<TreeNode> genTrees(int begin, int end){
        List<TreeNode> res = new ArrayList<>();
        if(begin > end){
            res.add(null); /* important to add null here */
            return res;
        }
        for(int i = begin; i <= end; i++){
            List<TreeNode> left = genTrees(begin, i-1);
            List<TreeNode> right = genTrees(i+1, end);
            for(TreeNode lNode : left){
                for(TreeNode rNode : right){
                    TreeNode root = new TreeNode(i);
                    root.left = lNode;
                    root.right = rNode;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
