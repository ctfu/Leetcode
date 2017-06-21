/* to decide if two points on the same line, use the concept of slope (y2-y1)/(x2-x1) = slope
 * but using calculate slope as hm key, would have a lot of corner cases to handle such as
 * sloep == 0 could be horizontal, or vertical line.
 * solution: using y->(y2-y1), and x->(x2-x1) as hashmap key to compare
 * starting from first point and see how many points after are on the same line with it */
public class Solution {
    public int maxPoints(Point[] points) {
        if(points == null || points.length == 0) return 0;
        Map<Integer, Map<Integer, Integer>> hm = new HashMap<Integer, Map<Integer, Integer>>();
        int res = 0;
        for(int i = 0; i < points.length; i++){
            /* points could be duplicate */
            int overlap = 0, max = 0;
            for(int j = i+1; j < points.length; j++){
                int x = points[i].x - points[j].x;
                int y = points[i].y - points[j].y;
                if(x == 0 && y == 0){
                    overlap++;
                }else{
                    int gcd = getGCD(x, y);
                    x /= gcd;
                    y /= gcd;
                    if(hm.containsKey(x)){
                        if(hm.get(x).containsKey(y)){
                            hm.get(x).put(y, hm.get(x).get(y) + 1);
                        }else{
                            hm.get(x).put(y, 1);
                        }
                    }else{
                        Map<Integer, Integer> temp = new HashMap<>();
                        temp.put(y, 1);
                        hm.put(x, temp);
                    }
                    max = Math.max(max, hm.get(x).get(y)); /* local max */
                }
            }
            res = Math.max(res, overlap + max + 1);/* plus 1, the i Point */
            hm.clear();
        }
        return res;
    }
    private int getGCD(int x, int y){
        if(y == 0) return x;
        else{
            return getGCD(y, x % y);
        }
    }
}
