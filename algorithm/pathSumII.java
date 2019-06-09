/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:

[
   [5,4,11,2],
   [5,8,4,5]
]
*/
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
            // should put the list into new arraylist since the templist will keep changing
            res.add(new ArrayList<Integer>(tempList));
        }else{ // here we can use else because it requires to end with the leaf
            sum(res, root.left, sum-root.val, tempList);
            sum(res, root.right, sum-root.val, tempList);
        }
        tempList.remove(tempList.size()-1); // remove the last value after recursion to the leaf
    }
}
