/* Approach: HashMap construct the tree, breadth first search the tree
 * time complexity: O(n), space complexity: O(n), at most each node is a parent node and has no child
 */
public class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, List<Integer>> hm = new HashMap<>();
        for (int i = 0; i < ppid.size(); i++) {
            if (!hm.containsKey(ppid.get(i))) {
                hm.put(ppid.get(i), new ArrayList<>());
            }
            hm.get(ppid.get(i)).add(pid.get(i));
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(kill);
        while (!queue.isEmpty()) {
            int top = queue.poll();
            res.add(top);
            if (hm.containsKey(top)) {
                for (int id : hm.get(top)) {
                    queue.offer(id);
                }
            }
        }
        return res;
    }
}
