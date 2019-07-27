/* Topological sort */
class Solution {
    public String alienOrder(String[] words) {
        if (words.length == 0) {
            return "";
        }
        Map<Character, Set<Character>> edges = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        // intilize every char having 0 indegree
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (!indegree.containsKey(c)) {
                    indegree.put(c, 0);
                }
            }
        }
        // calculate char indegree by comparing adacent words
        for (int i = 0; i < words.length - 1; i++) {
            String first = words[i];
            String second = words[i + 1];
            int length = Math.min(first.length(), second.length());
            for (int j = 0; j < length; j++) {
                char from = first.charAt(j);
                char to = second.charAt(j);
                if (from != to) {
                    if (!edges.containsKey(from)) {
                        edges.put(from, new HashSet<>());
                    }
                    Set<Character> set = edges.get(from);
                    if (!set.contains(to)) { // get rid of duplicate
                        set.add(to);
                        indegree.put(to, indegree.get(to) + 1);
                    }
                    // only need to find the first different comparision
                    // after this char, the char order in first maybe greater than the second' char
                    break;
                }
            }
        }
        Queue<Character> queue = new LinkedList<>();
        // get the chars having 0 indegrees
        for (Map.Entry<Character, Integer> entry : indegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.offer(entry.getKey());
            }
        }
        StringBuilder sb = new StringBuilder();
        // topological sort
        while (!queue.isEmpty()) {
            char c = queue.poll();
            sb.append(c);
            if (edges.containsKey(c)) {
                for (char c1 : edges.get(c)) {
                    indegree.put(c1, indegree.get(c1) - 1);
                    if (indegree.get(c1) == 0) {
                        queue.offer(c1);
                    }
                }
            }
        }
        return sb.length() == indegree.size() ? sb.toString() : "";
    }
}
