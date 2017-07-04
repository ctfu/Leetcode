/* Approach: Use a boolean variable to indicate if a node's parent has included(robbed)
 * time complexity: O(2^n)
 */
public class Solution {
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return robHouse(root, false);
    }

    public int robHouse(TreeNode root, boolean includedParent) {
        if (root == null) {
            return 0;
        }
        if (includedParent) {
            return robHouse(root.left, false) + robHouse(root.right, false);
        } else {
            int include = robHouse(root.left, true) + robHouse(root.right, true) + root.val;
            int notInclude = robHouse(root.left, false) + robHouse(root.right, false);
            return Math.max(include, notInclude);
        }
    }
}

/* Approach two: two decision to made to a node, either rob or not
 * time complexity: o(2^n)
 */
public class Solution {
    public int rob(TreeNode root) {
        return robHouse(root);
    }

    public int robHouse(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int money = root.val;
        if (root.left != null) {
            money += robHouse(root.left.left) + robHouse(root.left.right);
        }
        if (root.right != null) {
            money += robHouse(root.right.left) + robHouse(root.right.right);
        }
        return Math.max(money, robHouse(root.left) + robHouse(root.right));
    }
}

/* Improve: using HashMap to get rid of overlapping subproblems
 * time complexity: O(n), because store at most n nodes in the hashmap
 */
 public class Solution {
    public int rob(TreeNode root) {
        return robHouse(root, new HashMap<>());
    }

    public int robHouse(TreeNode root, Map<TreeNode, Integer> hm) {
        if (root == null) {
            return 0;
        }
        if (hm.containsKey(root)) {
            return hm.get(root);
        }
        int money = root.val;
        if (root.left != null) {
            money += robHouse(root.left.left, hm) + robHouse(root.left.right, hm);
        }
        if (root.right != null) {
            money += robHouse(root.right.left, hm) + robHouse(root.right.right, hm);
        }
        int max = Math.max(money, robHouse(root.left, hm) + robHouse(root.right, hm));
        hm.put(root, max);
        return max;
    }
}

/* Improve II; dynamic programming
 * store the calculation of two consition of a node (rob or not rob)
 * time complexity O(n)
*/
public class Solution {
    public int rob(TreeNode root) {
        int[] max = robHouse(root);
        return Math.max(max[0], max[1]);
    }

    public int[] robHouse(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] left = robHouse(root.left);
        int[] right = robHouse(root.right);
        int[] max = new int[2];
        max[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]); // not rob root
        max[1] = root.val + left[0] + right[0]; // rob root node 
        return max;
    }
}
