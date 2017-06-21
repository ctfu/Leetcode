/* HashMap for searching
 * spliting each word into two parts
 * time complexity: O(m * n^2), m is word length, n is word length
 * space complexity: O(n) */
public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        Map<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            hm.put(words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j <= words[i].length(); j++) {
                String part1 = words[i].substring(0, j);
                String part2 = words[i].substring(j);
                if (isPalindrom(part1)) {
                    String part2Rev = new StringBuilder(part2).reverse().toString();
                    // hm.get(part2Rev) != i to avoid search for itself
                    if (hm.containsKey(part2Rev) && hm.get(part2Rev) != i) {
                        List<Integer> list = new ArrayList<>();
                        list.add(hm.get(part2Rev));
                        list.add(i);
                        res.add(list);
                    }
                }
                // part1.length() < words[i].length() to get rid of duplicate seaching
                if (part1.length() < words[i].length() && isPalindrom(part2)) {
                    String part1Rev = new StringBuilder(part1).reverse().toString();
                    if (hm.containsKey(part1Rev) && hm.get(part1Rev) != i) {
                        List<Integer> list = new ArrayList<>();
                        list.add(i);
                        list.add(hm.get(part1Rev));
                        res.add(list);
                    }
                }
            }
        }
        return res;
    }

    public boolean isPalindrom(String word) {
        int begin = 0, end = word.length() - 1;
        while (begin < end) {
            if (word.charAt(begin++) != word.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
