/* A boomerange consists of three points [i,j,k], where distance between i and j is the same i and k
 * Approach: HashMap<Integer, Integer>, distance between two points as key, count as value
 * For each point, see how many points are of the same distance with it, the number of boomeranges for
 * the current point are 2 number permutation of the distance count */
public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        if(points[0].length == 0 || points.length < 3) return 0;
        Map<Integer, Integer> hm = new HashMap<>();
        int res = 0;
        for(int i = 0; i < points.length; i++){
            for(int j = 0; j < points.length; j++){ /* the order matters, so start from 0 */
                int distance = getDistance(points[i], points[j]);
                hm.put(distance, hm.getOrDefault(distance, 0)+1);
            }
            for(int count : hm.values()){
                res += count*(count-1); /* permutation of two numbers for the distance count, since 3 points for a boomerage*/
            }
            hm.clear();
        }
        return res;
    }
    public int getDistance(int[] a, int[] b){
        int x = a[0] - b[0];
        int y = a[1] - b[1];
        return x*x + y*y;       /* does not need to calculate the sqrt to be the key */
    }
}
