/* Recursive */
public class Solution {
    public TreeNode str2tree(String s) {
        if(s == null || s.length() == 0) return null;
        int pos = s.indexOf("(");
        int val = pos == -1 ? Integer.parseInt(s) : Integer.parseInt(s.substring(0, pos));
        TreeNode root = new TreeNode(val);
        if(pos == -1) return root;

        int start = pos, parenCount = 0;
        for(int i = pos; i < s.length(); i++){
            if(s.charAt(i) == '('){
                parenCount++;
            }else if(s.charAt(i) == ')'){
                parenCount--;
            }
            if(parenCount == 0){
                if(start == pos){
                    root.left = str2tree(s.substring(start+1, i));
                    start = i+1; /* start moves to right substring starting "(" */
                }else{
                    root.right = str2tree(s.substring(start+1, i));
                }
            }
        }
        return root;
    }
}
