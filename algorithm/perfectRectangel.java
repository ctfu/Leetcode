/* Approach: If all the small rectangles form a perfect rectangle, execpt the 4 corner points
 * all the inner points will be duplicated once. If use a set to detect duplicate and removed duplicate,
 * all that left will be only 4 corner points.
 * And the big rectange area (form by four corner points) will be the sum of all the areas of small rectangles
 */
public class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        if (rectangles.length == 0 || rectangles[0].length == 0) {
            return false;
        }
        Set<String> set = new HashSet<>();
        int x1 = Integer.MAX_VALUE;
        int y1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE;
        int y2 = Integer.MIN_VALUE;
        int area = 0;
        for (int[] rec : rectangles) {
            x1 = Math.min(x1, rec[0]);
            y1 = Math.min(y1, rec[1]);
            x2 = Math.max(x2, rec[2]);
            y2 = Math.max(y2, rec[3]);

            area += (rec[2] - rec[0]) * (rec[3] - rec[1]);

            String bl = rec[0] + " " + rec[1];
            String ul = rec[0] + " " + rec[3];
            String br = rec[2] + " " + rec[1];
            String ur = rec[2] + " " + rec[3];
            if (!set.add(bl)) set.remove(bl);
            if (!set.add(ul)) set.remove(ul);
            if (!set.add(br)) set.remove(br);
            if (!set.add(ur)) set.remove(ur);
        }
        if (set.size() != 4 || !set.contains(x1 + " " + y1) || !set.contains(x1 + " " + y2) ||
            !set.contains(x2 + " " + y2) || !set.contains(x2 + " " + y1)) {
                return false;
        }
        return area == (x2 - x1) * (y2 - y1);
    }
}
