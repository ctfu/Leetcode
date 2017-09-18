/* Approach: HashMap + serialization of a tree
* a duplicate is detected when there exists duplicate serilization of some substree */
class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        collectDuplicate(res, root, new HashMap<String, Integer>());
        return res;
    }
    public String collectDuplicate(List<TreeNode> res, TreeNode root, Map<String, Integer> hm) {
        if (root == null) {
            return "#";
        }
        String serial = root.val + "," + collectDuplicate(res, root.left, hm) + "," + collectDuplicate(res, root.right, hm);
        if (!hm.containsKey(serial)) {
            hm.put(serial, 0);
        }
        if (hm.get(serial) == 1) { // here shouldn't be >= 1, to avoid duplicate if exist multiple same tree
            res.add(root);
        }
        hm.put(serial, hm.get(serial) + 1);
        return serial;
    }
}
