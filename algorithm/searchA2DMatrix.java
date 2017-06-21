/* Approach: Binary Search
1. Integers in each row are sorted from left to right.
2. The first integer of each row is greater than the last integer of the previous row. */
/* important step is to calculate the row and col index of the mid point,
 * which is : matrix[mid / col][mid % col] */

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int begin = 0;
        int end = rows * cols - 1;

        while(begin <= end){
            int mid = begin + (end - begin)/2;
            if(matrix[mid/cols][mid%cols] == target){
                return true;
            }else if(matrix[mid/cols][mid%cols] > target){
                end = mid - 1;
            }else{
                begin = mid + 1;
            }
        }
        return false;
    }
}
