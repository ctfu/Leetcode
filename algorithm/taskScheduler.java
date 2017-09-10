/* Approach: PriorityQueue<Map.Entry<Character, Integer>> + waitQueue
Try to execute the task with highest frequency first */
class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> hm = new HashMap<>();
        // calculate task frequency
        for (int i = 0; i < tasks.length; i++) {
            hm.put(tasks[i], hm.getOrDefault(tasks[i], 0) + 1);
        }
        // sort the task frquency in desending order
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(hm.entrySet());
        Queue<Map.Entry<Character, Integer>> waitQueue = new LinkedList<>();
        int intervals = 0;
        while (!pq.isEmpty()) {
            int k = n + 1;
            while (!pq.isEmpty() && k > 0) { // execute task k at a time
                Map.Entry<Character, Integer> current = pq.poll();
                current.setValue(current.getValue() - 1);
                waitQueue.offer(current);
                intervals++;
                k--;
            }
            while (!waitQueue.isEmpty()) { // put back the task from waitQueue to pq, even if k != 0
                Map.Entry<Character, Integer> current = waitQueue.poll();
                if (current.getValue() > 0) {
                    pq.offer(current);
                }
            }
            if (pq.isEmpty()) { // if task put back still empty, then break
                break;
            }
            intervals = intervals + k;  // plus k as the idle time
        }
        return intervals;
    }
}
