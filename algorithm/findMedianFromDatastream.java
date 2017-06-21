/* Approach: minHeap, maxHeap, maintain heap balance */
public class MedianFinder {
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;

    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        if(minHeap.size() == 0 && maxHeap.size() == 0){ /* for the first number, choose one heap to add */
            minHeap.offer(num);
        }else if(minHeap.size() > maxHeap.size()){ /* minHeap size is bigger than max */
            if(num > minHeap.peek()){ /* compare the number to see which heap to add */
                maxHeap.offer(minHeap.poll()); /* since minHeap is already bigger, needs to poll() */
                minHeap.offer(num);
            }else{
                maxHeap.offer(num);
            }
        }else if(minHeap.size() < maxHeap.size()){
            if(num < maxHeap.peek()){
                minHeap.offer(maxHeap.poll());
                maxHeap.offer(num);
            }else{
                minHeap.offer(num);
            }
        }else{  /* if the heap is balanced */
            if(num > minHeap.peek()){
                minHeap.offer(num);
            }else{
                maxHeap.offer(num);
            }
        }
    }

    public double findMedian() {
        if(minHeap.size() == 0 && maxHeap.size()== 0) return 0.0;
        else if(minHeap.size() > maxHeap.size()){
            return minHeap.peek();
        }else if(minHeap.size() < maxHeap.size()){
            return maxHeap.peek();
        }else{
            return (minHeap.peek()+ maxHeap.peek())/2.0;
        }
    }
}

/* simplify method: always first add to the minHeap, once added, always poll the
 * smallest from the minHeap */
public class MedianFinder {
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;

    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        minHeap.offer(num);
        maxHeap.offer(minHeap.poll());
        if(minHeap.size() < maxHeap.size()){ /*always let minHeap.size() bigger than maxHeap */
            minHeap.offer(maxHeap.poll());
        }
    }

    public double findMedian() {
        if(minHeap.size() == maxHeap.size()){
            return (minHeap.peek() + maxHeap.peek())/2.0;
        }else{
            return minHeap.peek();
        }
    }
}
