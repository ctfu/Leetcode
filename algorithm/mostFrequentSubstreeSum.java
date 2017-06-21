/* 1. postorder to sumup each subtree
 * 2. Globla HashMap<sum, count> to count the substree sum frequency
 * 3. Global vairable mfreqSum to capture the most frequent subtree sum */
public class Solution {
    int mfreqSum = 0;
    Map<Integer, Integer> hm = new HashMap<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        treeSum(root);
        List<Integer> list = new ArrayList<>();
        for(int sum : hm.keySet()){
            if(hm.get(sum) == mfreqSum){
                list.add(sum);
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < res.length; i++){
            res[i] = list.get(i);
        }
        return res;
    }
    /* preorder traversal of the tree and count the subtree sum frequency */
    public int treeSum(TreeNode root){
        if(root == null) return 0;
        int left = treeSum(root.left);
        int right = treeSum(root.right);
        int sum = root.val + left + right;
        int count = hm.getOrDefault(sum, 0) + 1; /* count the substree sum frequency */
        hm.put(sum, count);
        mfreqSum = Math.max(mfreqSum, count); /* store the most frequent subtree sum */
        return sum;
    }
}
