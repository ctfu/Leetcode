public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new HashSet<>();
        Set<String> repeat = new HashSet<>();
        for (int i = 0; i + 10 <= s.length(); i++) {
            String str = s.substring(i, i + 10);
            if (!set.add(str)) {
                repeat.add(str);
            }
        }
        return new ArrayList<>(repeat);
    }
}
