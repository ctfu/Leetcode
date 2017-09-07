/* Approach 1: HashMap*/
class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        Map<String, List<Integer>> hm = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (!hm.containsKey(words[i])) {
                hm.put(words[i], new ArrayList<>());
                hm.get(words[i]).add(i);
            }
            hm.get(words[i]).add(i);
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < hm.get(word1).size(); i++) {
            for (int j = 0; j < hm.get(word2).size(); j++) {
                res = Math.min(res, Math.abs(hm.get(word1).get(i) - hm.get(word2).get(j)));
            }
        }
        return res;
    }
}

/* Approach 2: one pass for monitoring the target word index */
class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int w1 = -1, w2 = -1;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (word1.equals(words[i])) {
                w1 = i;
            }
            if (word2.equals(words[i])) {
                w2 = i;
            }
            if (w1 != -1 && w2 != -1) {
                res = Math.min(res, Math.abs(w1 - w2));
            }
        }
        return res;
    }
}
