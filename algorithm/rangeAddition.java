/* Approach: accumulated sum (cofigure the array, so tht each index is set to store the current accumulated sum)
 * time complexity: O(n + k) k updates, space complexity: O(1)
 */
public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for (int[] update : updates) {
            int begin = update[0], end = update[1], value = update[2];
            res[begin] += value;
            if (end < res.length - 1) {
                res[end+1] -= value;
            }
        }
        int sum = 0;
        for (int i = 0; i < res.length; i++) {
            sum += res[i];
            res[i] = sum;
        }
        return res;
    }
}
