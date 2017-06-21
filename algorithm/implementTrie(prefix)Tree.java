/* Method 1: TrieNode + Map<Character, TrieNode> children +  and a boolean field to indicate
 * if is the end of a word */
public class Trie {
    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(!cur.children.containsKey(c)){
                cur.children.put(c, new TrieNode());
            }
            cur = cur.children.get(c);
        }
        cur.endWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(!cur.children.containsKey(c)){
                return false;
            }
            cur = cur.children.get(c);
        }
        return cur.endWord; /* search whole world needs to see if word is end of the word */
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(!cur.children.containsKey(c)){
                return false;
            }
            cur = cur.children.get(c);
        }
        return true; /* search prefix does not need to indicate endOfWord */
    }
    /* the TrieNode datastructure */
    class TrieNode{
        Map<Character, TrieNode> children;
        boolean endWord; /* indicate the end of word */
        public TrieNode(){
            children = new HashMap<>();
            endWord = false;
        }
    }
}

/* Method 2: TrieNode with TrieNode[] children = new TrieNode[26], assuming only lower case chars */
public class Trie {
    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(cur.children[c-'a'] == null){
                cur.children[c-'a'] = new TrieNode();
            }
            cur = cur.children[c-'a'];
        }
        cur.endOfWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(cur.children[c-'a'] == null){
                return false;
            }
            cur = cur.children[c-'a'];
        }
        return cur.endOfWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(cur.children[c-'a'] == null){
                return false;
            }
            cur = cur.children[c-'a'];
        }
        return true;
    }

    class TrieNode{
        TrieNode[] children;
        boolean endOfWord;
        public TrieNode(){
            children = new TrieNode[26];
            endOfWord = false;
        }
    }
}
