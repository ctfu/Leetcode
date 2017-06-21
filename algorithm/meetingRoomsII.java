/* 1. Sort Interval by start, using minHeap to keep track of a smallest end interval
 * 2. merge two interval if no overlap (share one room)
 * 3. minHeap size is the number of rooms needed */
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b)-> a.start-b.start);   /* sort intervals by start */
        /* heap to keep track of smallest end */
        PriorityQueue<Interval> minHeap = new PriorityQueue<>((a,b)->a.end - b.end);
        minHeap.offer(intervals[0]);
        for(int i = 1; i < intervals.length; i++){
            Interval pre = minHeap.poll();
            if(intervals[i].start < pre.end){   /* push to heap when overlap */
                minHeap.offer(intervals[i]);
            }else{
                pre.end = intervals[i].end;     /* merge when no overlap */
            }
            minHeap.offer(pre);                 /* dont forget to add it back */
        }
        return minHeap.size();                  
    }
}
