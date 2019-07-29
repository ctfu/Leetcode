/*
Given a binary tree, imagine yourself standing on the right side of it,
return the values of the nodes you can see ordered from top to bottom.

Example:

Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
  */
/* Core idea: Standing by the right side of the tree, the tree is viewed like a top down list
 * 1. Each level only one node can be see and added
 * 2. Added that treeNode when viewDepth == treeDepth */
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        rightView(res, root, 0);
        return res;
    }
    public void rightView(List<Integer> res, TreeNode root, int curLevel){
        if(root == null){
            return;
        }
        /* viewDpeth is the size of the res */
        if(curLevel == res.size()){ /* levelWeSee == currentTreeLevel */
            res.add(root.val);
        }

        rightView(res, root.right, curLevel+1);/* move to next level, right first */
        rightView(res, root.left, curLevel+1);
    }
}
