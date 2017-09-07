class WordDistance {
    private Map<String, List<Integer>> hm = new HashMap<>();
    public WordDistance(String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (!hm.containsKey(words[i])) {
                hm.put(words[i], new ArrayList<>());
            }
            hm.get(words[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        // to reduce the time complexity from O(n^2) to O(n), use intersection of two list techniques 
        List<Integer> word1List = hm.get(word1);
        List<Integer> word2List = hm.get(word2);
        int res = Integer.MAX_VALUE;
        for (int i = 0, j = 0; i < word1List.size() && j < word2List.size();) {
            int w1 = word1List.get(i);
            int w2 = word2List.get(j);
            if (w1 < w2) {
                i++;
                res = Math.min(res, Math.abs(w1 - w2));
            } else {
                j++;
                res = Math.min(res, Math.abs(w1 - w2));
            }
        }
        return res;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */
