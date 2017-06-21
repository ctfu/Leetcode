/* Queue (keep the inserted value) + moving sum */
public class MovingAverage {
    private final int SIZE;
    private Queue<Integer> queue;
    private double sum;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        queue = new LinkedList<>();
        sum = 0;
        this.SIZE = size;
    }

    public double next(int val) {
        if(queue.size() >= SIZE){
            int del = queue.poll(); /* if reaches to window size, should subtract sum from the fist added number */
            sum -= del;
        }
        queue.offer(val);
        sum += val;
        return sum/queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
