/* Approach HashMap, similar to group anagram
* the shifting source can be the hashmap key such as "abc for bcd, xyz ...", 'ab for bc, cd ...' */
class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> hm = new HashMap<>();
        for (String str : strings) {
            String key = "";
            int offset = str.charAt(0) - 'a';
            // construct the source string as the key
            for (char c : str.toCharArray()) {
                char ch = (char)(c - offset);
                if (ch < 'a') {
                    ch = (char) (ch + 26);  // round it back to 'z'
                }
                key += ch;
            }
            if (!hm.containsKey(key)) {
                hm.put(key, new ArrayList<>());
            }
            hm.get(key).add(str);
        }
        for (List<String> list : hm.values()) {
            res.add(list);
        }
        return res;
    }
}
