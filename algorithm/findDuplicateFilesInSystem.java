/* Approach HashMap
* similar to group anagram, group shifted strings
* key is the same file content */
class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> hm = new HashMap<>();
        for (int j = 0; j < paths.length; j++) {
            String[] tokens = paths[j].split(" ");
            for (int i = 1; i < tokens.length; i++) {
                String fp = tokens[0] + "/" + tokens[i].substring(0, tokens[i].indexOf("("));
                String fc = tokens[i].substring(tokens[i].indexOf("(") + 1, tokens[i].indexOf(")"));
                if (!hm.containsKey(fc)) {
                    hm.put(fc, new ArrayList<>());
                }
                hm.get(fc).add(fp);
            }
        }
        for (List<String> list : hm.values()) {
            if (list.size() > 1) {
                res.add(list);
            }
        }
        return res;
    }
}
