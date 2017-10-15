/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
 /* convex hull problem: Monotone Chain algorithm
 time complexity: O(nlogn) for sorting
 */

public class Solution {
    // orientation function decides whether q is more anticlowise to p than r
    // cross product of pq and pr, and compare the slop of these two vectors
    // p - a point is already added
    // q - the next point beging consider to be added
    // r - a point from the remaining undecided points
    public int orientation(Point p, Point q, Point r) {
        return (q.y - p.y) * (r.x - p.x) - (q.x - p.x) * (r.y - p.y);
    }
    public List < Point > outerTrees(Point[] points) {
        List<Point> res = new ArrayList<>();
        // sor the points according to its x cordinations, if same, sort it with y cordinations in decreasing order
        Arrays.sort(points, new Comparator < Point > () {
            public int compare(Point p, Point q) {
                return q.x == p.x ? q.y - p.y : p.x - q.x;
            }
        });
        Stack < Point > hull = new Stack < > ();
        // left scan for lower hull
        for (int i = 0; i < points.length; i++) {
            // start with two points, passe the last two points and one remaining point to the orientation fucntion
            while (hull.size() >= 2 && orientation(hull.get(hull.size() - 2), hull.peek(), points[i]) > 0)
                hull.pop();
            hull.push(points[i]);
        }
        hull.pop(); // pop the last point to prepare for right scan upper hull
        for (int i = points.length - 1; i >= 0; i--) {
            while (hull.size() >= 2 && orientation(hull.get(hull.size() - 2), hull.peek(), points[i]) > 0)
                hull.pop();
            hull.push(points[i]);
        }
        res.addAll(new HashSet<>(hull)); // need HashSet to get rid of possible duplicate points added
        return res;
    }
}
