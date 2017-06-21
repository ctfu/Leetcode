/* Note: words may have duplicates, which will appearch in the same position in the Trie, need del-duplicate by set null */
public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if(board.length == 0 || board[0].length == 0) return res;

        TrieNode root = buildTrie(words);
        boolean[][] visited = new boolean[board.length][board[0].length];/* prevent repeat visite */
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                wordSearch(res, board, i, j, root, visited);
            }
        }
        return res;
    }
    public void wordSearch(List<String> res, char[][] board, int x, int y, TrieNode root, boolean[][] visited){
        if(x < 0 || x >= board.length || y < 0 || y >= board[x].length || visited[x][y] ||
                            root.children[board[x][y]-'a'] == null){
            return;
        }
        TrieNode node = root.children[board[x][y]-'a'];
        if(node.word != null){
            res.add(node.word); /* found a word */
            node.word = null;   /* delete word duplicate */
        }
        int[] dirct = {0, 1, 0, -1, 0};
        for(int i = 0; i < 4; i++){
            visited[x][y] = true;
            wordSearch(res, board, x+dirct[i], y+dirct[i+1], node, visited);
            visited[x][y] = false;
        }
    }
    /* build a trie tree with the words */
    public TrieNode buildTrie(String[]words){
        TrieNode root = new TrieNode();
        for(String word : words){
            TrieNode cur = root;
            for(char c : word.toCharArray()){
                if(cur.children[c-'a'] == null){
                    cur.children[c-'a'] = new TrieNode();
                }
                cur = cur.children[c-'a'];
            }
            cur.word = word; /* store the word at leaf node */
        }
        return root;
    }

    class TrieNode{
        TrieNode[] children;
        String word;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
}
