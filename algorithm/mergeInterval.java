/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
 /* sort the interval based on the start of interval, then merge */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<Interval>();
        if(intervals == null || intervals.size() == 0) return res;

        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval a, Interval b){
                return a.start - b.start;
            }
        });
        Interval pre = intervals.get(0);
        for(int i = 1; i < intervals.size(); i++){
            /* if second on overlaps with pre */
            if(intervals.get(i).start <= pre.end){
                /* merget to whoever has the larger end */
                pre.end = Math.max(intervals.get(i).end, pre.end);
            }else{
                /* no overlap add pre, assign new pre, because it is a reference,
                   create new Interval */
                res.add(new Interval(pre.start, pre.end));
                pre = intervals.get(i);
            }
        }
        res.add(pre); /* dont forget the last one */
        return res;
    }
}
