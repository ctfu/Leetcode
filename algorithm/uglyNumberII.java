/* The key is to keep track of the order of the ugly number
 * factor 2, 3, 5 separates the number into three sequence
 * Assume you have Uk, the kth ugly number. Then Uk+1 must be Min(L1 * 2, L2 * 3, L3 * 5)*/
 public class Solution {
     public int nthUglyNumber(int n) {
         int[] ugly = new int[n];
         ugly[0] = 1;
         int factor2 = 2, factor3 = 3, factor5 = 5;
         int index2 = 1, index3 = 1, index5 = 1;
         for(int i = 1; i < n; i++){
             /* merging the ugly numbers in the three groups ugly number list */
             int min = Math.min(Math.min(factor2, factor3), factor5);
             ugly[i] = min;
             if(min == factor2){
                 factor2 = 2 * ugly[index2++];
             }
             if(min == factor3){
                 factor3 = 3 * ugly[index3++];
             }
             if(min == factor5){
                 factor5 = 5 * ugly[index5++];
             }
         }
         return ugly[n-1];
     }
 }
