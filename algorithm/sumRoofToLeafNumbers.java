/* recursive method */
public class Solution {
    public int sumNumbers(TreeNode root) {
        sumNumbers(root, new StringBuilder());
        return sum;
    }
    private void sumNumbers(TreeNode root, StringBuilder sb){
        int sum = 0;
        if(root == null){
            return;
        }
        sb.append(root.val);
        if(root.left == null && root.right == null){    /* read to a leaf node */
            sum += Integer.parseInt(sb.toString());
        }else{
            sum += sumNumbers(root.left, sb);
            sum += sumNumbers(root.right, sb);
        }
        sb.setLength(sb.length()-1);
    }
}

/* Method 2: no global variable */
public class Solution {
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }
    private int sumNumbers(TreeNode root, int sum){
        if(root == null) return 0;
        sum = sum*10 + root.val;    /* calculating current while traversing down */
        if(root.left == null && root.right == null){
            return sum;
        }
        return sumNumbers(root.left, sum) + sumNumbers(root.right, sum); /* left tree + right tree */
    }
}
