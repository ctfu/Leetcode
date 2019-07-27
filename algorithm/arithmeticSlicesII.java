/*
A sequence of numbers is called arithmetic if it consists of at least three
elements and if the difference between any two consecutive elements is the same.

Input: [2, 4, 6, 8, 10]

Output: 7

Explanation:
All arithmetic subsequence slices are:
[2,4,6]
[4,6,8]
[6,8,10]
[2,4,6,8]
[4,6,8,10]
[2,4,6,8,10]
[2,6,10]
*/
/* difference between arithmetic slide 1 is that:
 * this one includes the results of airthmetic slides of subsequences.
 * 1. use hashmap array to count each index's hmap<distance, counter>()
 * 2. if encounter the distance key twice, then this is a arithmetic slide
 * 3. the number can be negative, there is chance of overflow after substration*/
public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A == null || A.length == 0) return 0;
        int res = 0;
        Map<Integer, Integer>[] hm = new HashMap[A.length];/* hm array*/
        for(int i = 0; i < A.length; i++){
            hm[i] = new HashMap<Integer, Integer>();/* hm for each index */
            for(int j = 0; j < i; j++){
                long diff = (long)A[i] - A[j];
                /* handle difference overflow */
                if(diff < Integer.MIN_VALUE || diff > Integer.MAX_VALUE) continue;

                int d = (int)diff;
                int vi = hm[i].getOrDefault(d, 0);/* times i index has encounter d previously */
                int vj = hm[j].getOrDefault(d, 0);/* time j index has encounter d previously */
                res += vj; /* if there is anything reture, the d has encounter before */
                hm[i].put(d, vi + vj + 1);/* update ecounter times for index i */
            }
        }
        return res;
    }
}
