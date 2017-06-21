public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        sum(res, root, sum, new ArrayList<Integer>());
        return res;
    }
    private void sum(List<List<Integer>> res, TreeNode root, int sum, List<Integer> tempList){
        if(root == null){
            return;
        }

        tempList.add(root.val);
        if(sum == root.val && root.left == null && root.right == null){
            res.add(new ArrayList<Integer>(tempList));
        }else{
            sum(res, root.left, sum-root.val, tempList);
            sum(res, root.right, sum-root.val, tempList);
        }
        tempList.remove(tempList.size()-1);
    }
}
