/* Given an array of 2n integers, your task is to group these integers into n pairs
of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for
all i from 1 to n as large as possible.

Example 1:
Input: [1,4,3,2]

Output: 4
Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
*/
/* in order to make the min(ai, bi) the biggest, we need to pair smallest one
 * with the second smallest one, so that bigger number will have a chance to be
 * sum up */
class Solution {
    public int arrayPairSum(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {   // sum all the number in the even position 
                res += nums[i];
            }
        }
        return res;
    }
}
