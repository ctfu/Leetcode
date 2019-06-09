Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.

Example:

Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3
-------------------------------------------------------------------------------
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
    // second way for the second function
    private void findPath(List<String> list, TreeNode root, String path) {
        if (root == null) return;

        path += root.val;
        if (root.left == null && root.right == null) {
        list.add(path);
        } else {
            path += "->"; // dont need to get rid of "->"
            findPath(list, root.left, path);
            findPath(list, root.right, path);
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
