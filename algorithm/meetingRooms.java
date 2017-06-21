/* Merge Interval overlap 
 * Note: when b.start = a.end, consider the meeting still can be attended */
public class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) return true;
        Arrays.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval a, Interval b){
                return a.start-b.start;
            }
        });
        Interval pre = intervals[0];
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i].start < pre.end){   /* can't attend only when less than */
                return false;
            }else{
                pre = intervals[i];
            }
        }
        return true;
    }
}
