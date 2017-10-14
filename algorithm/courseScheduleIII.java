/* Approach:
* combination approach is TLE, we can try to take each course after sorting by its end dates,
* if a course can be taken, accumulate its time, if not, try to take it by replace the course taken
* that has maximum time, if that maximum time is greater than current course, we are guarrantee that
* the current course can be fit in the schedule and we can save some time by calculating the time difference
*/
class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        List<Integer> taken = new ArrayList<>();
        int days = 0;
        for (int[] c : courses) {
            if (days + c[0] <= c[1]) {
                days += c[0];
                taken.add(c[0]);
            } else {
                int max_id = 0;
                for (int j = 1; j < taken.size(); j++) {
                    if (taken.get(j) > taken.get(max_id)) {
                        max_id = j;
                    }
                }
                if (taken.get(max_id) > c[0]) {
                    days -= taken.get(max_id) - c[0];
                    // note the replaced course won't have a change to be consider again, because
                    // if the replaced cousre can fit in, current course is guarrantee to fit in.
                    taken.set(max_id, c[0]);
                }
            }
        }
        return taken.size();
    }
}
