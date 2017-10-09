/* Given an array of 2n integers, your task is to group these integers into n pairs
of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for
all i from 1 to n as large as possible. */

class Solution {
    public int arrayPairSum(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                res += nums[i];
            }
        }
        return res;
    }
}
