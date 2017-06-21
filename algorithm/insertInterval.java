/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
 /* insert newInterval to intervals list element */
/* 1) find the insert postion of intervals
 * 2) merge interval after that position */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        if(intervals.size() == 0){
            res.add(newInterval);
            return res;
        }

        for(int i = 0; i < intervals.size(); i++){
            Interval curInterval = intervals.get(i);
            if(newInterval.start <= curInterval.end){
                /* newInterval insert before current interval */
                if(newInterval.end < curInterval.start){
                    res.add(newInterval);
                }else{
                    /* merget curInterval and newInterval */
                    curInterval.start = Math.min(newInterval.start, curInterval.start);
                    curInterval.end = Math.max(newInterval.end, curInterval.end);
                }
                return mergetInterval(res, intervals, curInterval, i);
            }else{
                res.add(curInterval);
            }
        }
        res.add(newInterval);/* dont forget the last one */
        return res;
    }
    /* merget interval */
    public List<Interval> mergetInterval(List<Interval> res, List<Interval> intervals, Interval pre, int position){
        for(int i = position; i < intervals.size(); i++){
            if(intervals.get(i).start <= pre.end){
                pre.end = Math.max(intervals.get(i).end, pre.end);
            }else{
                res.add(new Interval(pre.start, pre.end));
                pre = intervals.get(i);
            }
        }
        res.add(pre);/* dont forget the last one */
        return res;
    }
}

/* better solution: insert intervals elements to newInterval*/

public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        if(intervals.size() == 0){
            res.add(newInterval);
            return res;
        }

        for(int i = 0; i < intervals.size(); i++){
            Interval curInterval = intervals.get(i);
            if(curInterval.end < newInterval.start){
                res.add(curInterval);
            }else if(curInterval.start <= newInterval.end){
                newInterval.start = Math.min(curInterval.start, newInterval.start);
                newInterval.end = Math.max(curInterval.end, newInterval.end);
            }else{
                res.add(new Interval(newInterval.start, newInterval.end));
                newInterval = curInterval;
            }
        }
        res.add(newInterval);
        return res;
    }
}
