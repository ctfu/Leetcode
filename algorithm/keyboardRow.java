/* Approach: HashMap to store characters on the same row */
class Solution {
    public String[] findWords(String[] words) {
        if (words.length == 0) {
            return new String[0];
        }
        String[] keyboard = {"QWERTYUIOP", "ASDFGHJKL", "ZXCVBNM"};
        Map<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < keyboard.length; i++) {
            for (Character c : keyboard[i].toCharArray()) {
                hm.put(c, i);
            }
        }
        List<String> res = new ArrayList<>();
        for (String word : words) {
            int rowIndex = hm.get(Character.toUpperCase(word.charAt(0)));
            for (Character c : word.toUpperCase().toCharArray()) {
                if (hm.get(c) != rowIndex) {
                    rowIndex = -1;  // set a flag to indicate not able to type in the same row
                    break;
                }
            }
            if (rowIndex != -1) {
                res.add(word);
            }
        }
        return res.toArray(new String[res.size()]);
    }
}
