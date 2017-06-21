public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(strs == null || strs.length == 0) return res;
        Map<String, List<String>> hm = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            String str = strs[i];
            char[] strArray = str.toCharArray();
            Arrays.sort(strArray);
            String newStr = new String(strArray);
            if(!hm.containsKey(newStr)){
                hm.put(newStr, new ArrayList<String>());
            }
            hm.get(newStr).add(str);
        }

        for(List<String> list : hm.values()){
            res.add(list);
        }
        return res;
    }
}
