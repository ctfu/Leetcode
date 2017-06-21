/* Binary search range: mid = (smallestValue + highestValue)/2
 * Question Reuqirements:
 * 1. n * n matrix
 * 2. kth smallest element, not the dististinct element */
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int begin = matrix[0][0], end = matrix[matrix.length-1][matrix[0].length-1]+1;/* [begin end) */
        while(begin < end){
            int mid = begin + (end-begin)/2;
            int count = 0;
            int j = matrix[0].length-1;
            for(int i = 0; i < matrix.length; i++){
                while(j >= 0 && matrix[i][j] > mid) j--;
                count += j+1;/* count how many number less than or equal to mid */
            }
            if(count < k){
                begin = mid + 1;
            }else{
                end = mid;
            }
        }
        return begin;
    }
}
