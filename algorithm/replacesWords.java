/* solution 1 */
class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        Set<String> set = new HashSet<>(dict);
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            for (int j = 1; j <= words[i].length(); j++) {
                String root = words[i].substring(0, j);
                if (set.contains(root)) {
                    words[i] = root;
                    break;
                }
            }
            sb.append(words[i] + " ");
        }
        return sb.substring(0, sb.length() - 1);
    }
}

/* solution 2: Trie Tree */
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
