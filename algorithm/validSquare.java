/* Approach: A square of 4 points form 6 distance, the max diagonal distance (2) are the same, the sides distance(4) are the same */
public class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        long[] distance = {getDistance(p1, p2), getDistance(p1, p3), getDistance(p1, p4),
            getDistance(p2, p3), getDistance(p2, p4), getDistance(p3, p4)};
        long max = 0;
        for (long d : distance) {
            max = Math.max(max, d);
        }
        int diagonal = 0;
        long side = 0;
        for (int i = 0; i < distance.length; i++) {
            if (distance[i] == max) {
                diagonal++;
            } else {
                side = distance[i];
            }
        }
        if (diagonal != 2) {
            return false;
        }
        for (long d : distance) {
           if (d != max && d != side) {
               return false;
           }
        }
        return true;
    }

    public long getDistance(int[] p1, int[] p2) {
        return (long)Math.pow(p1[0] - p2[0], 2) + (long)Math.pow(p1[1] - p2[1], 2);
    }
}
