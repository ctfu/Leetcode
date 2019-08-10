/*
Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND
of all numbers in this range, inclusive.

Example 1:

Input: [5,7]
Output: 4
Example 2:

Input: [0,1]
Output: 0
*/
/* Approach:
1. if m != n, from right to left, the & of digits will always equals 0
2. right shift m,n until they euqals */
class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if (m == 0) {
            return 0;
        }
        int res = 1;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            res <<= 1; // left shift since the & of current digits equals 0
        }
        return m * res;
    }
}
