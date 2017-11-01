/* total of m + n - 1 times of scans, represented by s
check the x, and y position of the staring element, the rest elements are just increasing x while decreasing y, or vice versa
if (s % 2 == 0): scanning up right
int x = s < rows ? s : rows - 1;
int y = s < rows ? 0 : s - (rows - 1);

if (s % 2 == 1): scanning down left
int x = s < n ? 0 : s - (cols - 1);
int y = s < n ? s : cols - 1;

time complexity: O(Math.max(mm, mn, nn)), space complexity: O(n);
*/
class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int rows = matrix.length, cols = matrix[0].length;
        int numberOfScan = rows + cols - 1;
        int[] res = new int[rows * cols];
        int index = 0;
        for (int i = 0; i < numberOfScan; i++) {
            if (i % 2 == 0) {
                int x = i < rows ? i : rows - 1;
                int y = i < rows ? 0 : i - (rows - 1);
                while (x >= 0 && y < cols) {
                    res[index++] = matrix[x--][y++];
                }
            } else {
                int x = i < cols ? 0 : i - (cols - 1);
                int y = i < cols ? i : cols - 1;
                while (x < rows && y >= 0) {
                    res[index++] = matrix[x++][y--];
                }
            }
        }
        return res;
    }
}
