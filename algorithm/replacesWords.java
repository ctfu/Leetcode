/* Trie Tree */
class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        StringBuilder res = new StringBuilder();
        TrieNode root = buildTrie(dict);
        String[] words = sentence.split(" ");
        for (String word : words) {
            res.append(search(root, word));
            res.append(" ");
        }
        return res.substring(0, res.length() - 1);
    }

    public String search(TrieNode root, String word) {
        StringBuilder sb = new StringBuilder();
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            sb.append(c);
            if (cur.children[c - 'a'] != null) {
                cur = cur.children[c - 'a'];
                if (cur.isWord) {
                    return sb.toString();
                }
            } else {
                return word;
            }
        }
        return word;
    }

    public TrieNode buildTrie(List<String> dict) {
        TrieNode root = new TrieNode();
        for (int i = 0; i < dict.size(); i++) {
            TrieNode cur = root;
            for (char c : dict.get(i).toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode();
                }
                cur = cur.children[c - 'a'];
            }
            cur.isWord = true;
        }
        return root;
    }

    class TrieNode {
        TrieNode[] children;
        boolean isWord;
        public TrieNode() {
            children = new TrieNode[26];
            this.isWord = false;
        }
    }
}
