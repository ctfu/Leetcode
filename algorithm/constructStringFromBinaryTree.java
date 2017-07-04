/* Example: preorder traversal of the tree:
 * [1, 2, 3, 4] => origin string "1(2(4)())(3()())" => "1(2(4))(3)"
 * [1,2,3,null,4] => "1(2()(4))(3)" can omit the left tree node here, or 4 will be consider the left node
 * require not to break the one-on-one mapping relationship between the tree structure and the string representation
 * which means left subtree's prenthesis can't omitted if there is a right substree node
 * time complexity: o(n), space complexity: O(n), the recursive depth can go up to n nodes
 */
public class Solution {
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(t.val);
        String left = tree2str(t.left);
        String right = tree2str(t.right);
        if (t.left != null || t.left == null && t.right != null){
            sb.append("(");
            sb.append(left);
            sb.append(")");
        }
        if (t.right != null) {
            sb.append("(");
            sb.append(right);
            sb.append(")");
        }
        return sb.toString();
    }
}
