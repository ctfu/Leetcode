/* Apporach 1: Queue, space complexity: O(n) */
public class ZigzagIterator {
    private Queue<Integer> queue = new LinkedList<>();
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        int i = 0, j = 0;
        while (i < v1.size() || j < v2.size()) {
            if (i < v1.size()) {
                queue.offer(v1.get(i++));
            }
            if (j < v2.size()) {
                queue.offer(v2.get(j++));
            }
        }
    }

    public int next() {
        return queue.poll();
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

/* Approach 2: two iterator, space complexity: O(1) */
public class ZigzagIterator {
    private Iterator<Integer> i, j, temp;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        i = v1.iterator();
        j = v2.iterator();
    }

    public int next() {
        if (i.hasNext()) {  // set a rule to first fetch from i, then swap iterator
            int rm = i.next();
            temp = i;
            i = j;
            j = temp;
            return rm;
        }
        return j.next();
    }

    public boolean hasNext() {
        return i.hasNext() || j.hasNext();
    }
}
