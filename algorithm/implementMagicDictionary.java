/* Use HashSet instead of Trie for the dictionary */
class MagicDictionary {
    private Set<String> hashSet;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        hashSet = new HashSet<>();
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String string : dict) {
            hashSet.add(string);
        }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        // modify one char of word
        char[] wordToken = word.toCharArray();
        for (int i = 0; i < wordToken.length; i++) {
            char ch = wordToken[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == ch) {
                    continue;
                }
                wordToken[i] = c;
                if (hashSet.contains(new String(wordToken))) {
                    return true;
                }
            }
            wordToken[i] = ch;
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */
