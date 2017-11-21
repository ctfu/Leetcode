/* Approach: simulates partion into k groups through backtracking */
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = sum(nums);
        if (sum % k != 0) {
            return false;
        }
        int subSum = sum / k;
        Arrays.sort(nums);
        int start = nums.length - 1;
        if (nums[start] > subSum) {
            return false;
        }
        while (start >= 0 && nums[start] == subSum) {
            start--;
            k--;
        }
        return partition(new int[k], nums, start, subSum);
    }

    public boolean partition(int[] subsets, int[] nums, int index, int subSum) {
        if (index < 0) {
            return true;
        }
        int selected = nums[index];
        for (int i = 0; i < subsets.length; i++) {
            if (subsets[i] + selected <= subSum) {
                subsets[i] += selected;
                if (partition(subsets, nums, index - 1, subSum)) {
                    return true;
                }
                subsets[i] -= selected;
            }
        }
        return false;
    }

    public int sum(int[] nums) {
        int res = 0;
        for (int n : nums) {
            res += n;
        }
        return res;
    }
}
