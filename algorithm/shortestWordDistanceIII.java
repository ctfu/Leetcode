/* if word1 and word2 can be the smae word, means they could be in one index list */
class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        Map<String, List<Integer>> hm = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (!hm.containsKey(words[i])) {
                hm.put(words[i], new ArrayList<>());
            }
            hm.get(words[i]).add(i);
        }
        if (word1.equals(word2)) {
            return getShortest1(hm, word1);
        } else {
            return getShortest2(hm, word1, word2);
        }
    }

    public int getShortest1(Map<String, List<Integer>> hm, String word) {
        List<Integer> list = hm.get(word);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < list.size() - 1; i++) {
            res = Math.min(res, Math.abs(list.get(i) - list.get(i + 1)));
        }
        return res;
    }

    public int getShortest2(Map<String, List<Integer>> hm, String word1, String word2) {
        List<Integer> list1 = hm.get(word1);
        List<Integer> list2 = hm.get(word2);
        int res = Integer.MAX_VALUE;
        for (int i = 0, j = 0; i < list1.size() && j < list2.size();) {
            int index1 = list1.get(i);
            int index2 = list2.get(j);
            if (index1 < index2) {
                i++;
                res = Math.min(res, Math.abs(index1 - index2));
            } else {
                j++;
                res = Math.min(res, Math.abs(index1 - index2));
            }
        }
        return res;
    }
}
