/* Approach: to perform the permuation of half of the string and form the whole palindrom string before adding to the result */
public class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        List<Character> list = new ArrayList<>();
        /* hashmap to check if string can form palindrom string and
         * to from split half of the string when passes check */
        Map<Character, Integer> hm = new HashMap<>();
        int odd = 0;
        String mid = "";    // contains all the odd count of chars in the string 
        for (char c : s.toCharArray()) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : hm.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                odd++;
            }
        }
        if (odd > 1) {
            return res;
        }
        for (Map.Entry<Character, Integer> entry : hm.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();
            if (value % 2 != 0) {
                mid += key;
            }
            for (int i = 0; i < value / 2; i++) {
                list.add(key);
            }
        }
        genPermutation(res, list, mid, new StringBuilder(), new boolean[list.size()]);
        return res;
    }

    public void genPermutation(List<String> res, List<Character> list, String mid, StringBuilder sb, boolean[] visited) {
        if (sb.length() == list.size()) {
            String str = sb.toString() + mid + sb.reverse();
            res.add(str);
            sb.reverse();
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (visited[i] || i > 0 && list.get(i) == list.get(i - 1) && !visited[i-1]) {
                    continue;
                }
                visited[i] = true;
                sb.append(list.get(i));
                genPermutation(res, list, mid, sb, visited);
                visited[i] = false;
                sb.setLength(sb.length() - 1);
            }
        }
    }
}
