public class WordDictionary {
    TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            if (cur.children[word.charAt(i)-'a'] == null) {
                cur.children[word.charAt(i)-'a'] = new TrieNode();
            }
            cur = cur.children[word.charAt(i)-'a'];
        }
        cur.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        TrieNode cur = root;
        return search(word, cur);
    }

    private boolean search(String word, TrieNode root) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == '.') {
                for (int j = 0; j < cur.children; j++) {
                    if (cur.children[j] != null && search(word.substring(i+1), cur.children[j])) {
                        return true;
                    }
                }
                return false;
            } else {
                if (cur.children[word.charAt(i)-'a'] == null) {
                    return false;
                }
                cur = cur.children[word.charAt(i)-'a'];
            }
        }
        return cur.isWord;
    }
}

class TrieNode {
    boolean isWord;
    TrieNode[] children;

    public TrieNode() {
        children = new TrieNode[26];
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
