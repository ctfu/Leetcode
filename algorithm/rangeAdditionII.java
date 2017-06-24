/* Approach: transform the problem to minimum overlapping elements in the matrix
 * time complexity: O(k), k updates, space complexity: O(1)
 */
public class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int minRow = Integer.MAX_VALUE;
        int minCol = Integer.MAX_VALUE;
        for (int[] update : ops) {
            // calculate minimum row and column overlappings
            minRow = Math.min(minRow, update[0]);
            minCol = Math.min(minCol, update[1]);
        }
        if (minRow == Integer.MAX_VALUE || minCol == Integer.MIN_VALUE) {
            return m * n;
        } else {
            return minRow * minCol;
        }
    }
}
