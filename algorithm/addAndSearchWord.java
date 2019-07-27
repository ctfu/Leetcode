/* Approach 1: */
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
                    // important to pass the substring(i + 1) instad of the whole string
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

/* Approach 2: recursion */
class WordDictionary {
    private TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            if (current.children[c - 'a'] == null) {
                current.children[c - 'a'] = new TrieNode();
            }
            current = current.children[c - 'a'];
        }
        current.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        TrieNode current = root;
        return searchHelper(word, current, 0);
    }

    public boolean searchHelper(String word, TrieNode root, int index) {
        if (index == word.length()) {
            return root.isWord;
        }
        char c = word.charAt(index);
        if (c == '.') {
            for (int i = 0; i < root.children.length; i++) {
                if (root.children[i] != null && searchHelper(word, root.children[i], index + 1)) {
                    return true;
                }
            }
            return false;
        } else {
            return root.children[c - 'a'] != null && searchHelper(word, root.children[c - 'a'], index + 1);
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
