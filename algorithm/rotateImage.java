/* To rotate the matrix clockwise 90
 * 1. reverse matrix vertically (first row swap with last row, ...)
 * 2. symmetric swapping
 * To rotate the matrix anticlockwise 90
 * 1. reverse matrix horizontally (column swapping)
 * 2. Symmetric swapping */
public class Solution {
    public void rotate(int[][] matrix) {
        /* rows swapping */
        for(int i = 0; i < matrix.length/2; i++){
            int[] temp = matrix[i];
            matrix[i] = matrix[matrix.length-1-i];
            matrix[matrix.length-1-i] = temp;
        }
        /* symmetric swapping */
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < i; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
