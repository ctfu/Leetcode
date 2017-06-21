/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        String path = "";
        treePaths(root, paths, path);
        return paths;
    }
    private void treePaths(TreeNode root, List<String> paths, String path){
        if(root == null){
            return;
        }
        path += root.val + "->";
        treePaths(root.left, paths, path);
        treePaths(root.right, paths, path);
        if(root.left == null && root.right == null){
            /* "->" consider as two characters, '-' and '>', that's why -2 */
            paths.add(path.substring(0, path.length() -2)); //to get rid of the last "->"
        }
    }
}

//using String concatenation copy string each time, using StringBuilder to improve,
//but StringBuilder is mutable, it will hold its value after backtracking, so a lenth needs
//to be set before going into recursion.
public List<String> binaryTreePaths(TreeNode root) {
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    helper(res, root, sb);
    return res;
}

private void helper(List<String> res, TreeNode root, StringBuilder sb) {
    if(root == null) {
        return;
    }
    int len = sb.length();  //remember the length before going into recursion
    sb.append(root.val);
    if(root.left == null && root.right == null) {
        res.add(sb.toString());
    } else {
        sb.append("->");
        helper(res, root.left, sb);
        helper(res, root.right, sb);
    }
    sb.setLength(len);  //set the lenth back
}
