/* The problem assumes k is always valid, 1<=k<=n
 * o(nlogk) solution using PriorityQueue to keep a k window */
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        /* store the element in reverse order */
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, Collections.reverseOrder());
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            heap.offer(nums[i]);
            if(heap.size() == k){
                res[index++] = heap.peek();
                heap.remove((Integer)nums[i+1-k]);
            }
        }
        return res;
    }
}

/* o(n)(eachelelment add and remove once) solution using Deque<Integer> to store elements index */
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return new int[0];
        }
        /* the result length could directly calculated n-k+1 */
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        /* deque to store nums index */
        Deque<Integer> queue = new LinkedList<>();
        for(int i = 0; i < nums.length; i++){
            /* maintain a k window */
            if(!queue.isEmpty() && queue.peek() < i + 1 - k{ /* starting index of k window is i-(k-1) */
                queue.poll();
            }
            /* within k window, store only the potential max value */
            /* i.e. within a 3 window [1,3,6], 3 will never be consider as max value
            /* it is similar to maintina k window monatonic decreasing stack */
            while(!queue.isEmpty() && nums[queue.peekLast()] < nums[i]){
                queue.pollLast();
            }
            queue.offer(i);
            /* if reaches to k window size, queue.peek() stores the max value index */
            if(i >= k - 1){
                res[index++] = nums[queue.peek()];
            }
        }
        return res;
    }
}
