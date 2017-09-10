/* Question: Rearrange string so that each same character is at least k distance away
* Greedy approach: try to construct the highest frequency char first
* time complexity: O(nlogn), because of the heap construction */
class Solution {
    public String rearrangeString(String s, int k) {
        Map<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(hm.entrySet()); // using addAll() instead of using a for loop 
        Queue<Map.Entry<Character, Integer>> waitQueue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> current = pq.poll();
            sb.append(current.getKey());
            current.setValue(current.getValue() - 1); // entry.setValue() function
            waitQueue.offer(current);
            if (waitQueue.size() < k) { // to maintain a k gap before put pack that same character into pq
                continue;
            }
            current = waitQueue.poll();
            if (current.getValue() > 0) {
                pq.offer(current);
            }
        }
        return sb.length() == s.length() ? sb.toString() : "";
    }
}
