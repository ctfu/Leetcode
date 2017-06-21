/* Method 1: HashMap to count frequency, max to count max frequency  O(n), O(n) space */
public class Solution {
    private Map<Integer, Integer> hm = new HashMap<>();
    private int maxCount = 0;

    public int[] findMode(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root);
        for(int key : hm.keySet()){
            if(hm.get(key) == maxCount){
                list.add(key);
            }
        }
        int[] modes = new int[list.size()];
        for(int i = 0; i < list.size();i++){
            modes[i] = list.get(i);
        }
        return modes;
    }
    private void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        int count = hm.getOrDefault(root.val, 0) + 1;
        maxCount = Math.max(maxCount, count);
        hm.put(root.val, count);
        inorder(root.right);
    }
}

/* Method 2: o(n) complexity, o(1) space if not count inorder stack space */
/* Approach: two tree traversal, first find how many modes and the maxCount, second fine the mode number */
public class Solution {
    private int curVal = 0;
    private int curCount = 0;
    private int maxCount = 0;
    private int numOfModes = 0; /* count how many modes */
    private int[] modes;

    public int[] findMode(TreeNode root) {
        inorder(root);  /* first traversal */
        modes = new int[numOfModes];    /* then intit the modes */
        curCount = 0;   /* remember to reset, but maxCount */
        numOfModes = 0;
        inorder(root);  /* second traversal */
        return modes;
    }
    /* inorder traversal, so the value will be sorted in increasing order
     * here can be replace with Morris traversal to achieve o(1) space */
    private void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        handleValue(root.val);  /* count each value */
        inorder(root.right);
    }
    private void handleValue(int val){
        if(val != curVal){
            curVal = val;
            curCount = 0;
        }
        curCount++;
        if(curCount > maxCount){ /* for the first traversal come here, second traversal wont't */
            maxCount = curCount;
            numOfModes = 1;
        }else if(curCount == maxCount){
            if(modes != null){  /* if it's the second traversal */
                modes[numOfModes] = curVal;
            }
            numOfModes++;
        }
    }
}
