/* Approach: Sorting + HashSet */
class Solution {
    public String longestWord(String[] words) {
        Set<String> dict = new HashSet<>();
        for (String word : words) {
            dict.add(word);
        }
        Arrays.sort(words, (a, b) -> {
           if (a.length() != b.length()) {
               return a.length() - b.length();
           } else {
               return b.compareTo(a);
           }
        });
        for (int i = words.length - 1; i >= 0; i--) {
            if (buildWord(dict, words[i])) {
                return words[i];
            }
        }
        return "";
    }
    public boolean buildWord(Set<String> dict, String word) {
        for (int i = 1; i < word.length(); i++) {
            if (!dict.contains(word.substring(0, i))) {
                return false;
            }
        }
        return true;
    }
}
