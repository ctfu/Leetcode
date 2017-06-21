/* time complexity o(logn), base is 5 */
public class Solution {
    //all trailing zeros are from 5 * 2.
    //so only count how many 5 factors within n, 2 is included in 5 factorial
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n/5);
    }
}
