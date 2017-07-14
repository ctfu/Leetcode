/* Approach: DFS, idea is that given a set of numbers, divided the number into equal 4 sets
* time complexity: O(4 ^ n)
*/
public class Solution {
    public boolean makesquare(int[] nums) {
        if (nums.length < 4) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 4 != 0) {
            return false;
        }
        Arrays.sort(nums);
        reverse(nums); // sorted in desending order improve dfs by always try the longest first
        return divideEqualSet(nums, new int[4], sum / 4, 0);
    }
    // a recursive method to divided the numbers into 4 equal sets with the same value
    public boolean divideEqualSet(int[] nums, int[] equalSet, int target, int index) {
        if (index == nums.length) {
            if (equalSet[0] == target && equalSet[1] == target && equalSet[2] == target) {
                return true;
            }
            return false;
        }
        // try to put nums[index] in one of the 4 slots
        for (int i = 0; i < 4; i++) {
            if (equalSet[i] + nums[index] > target) continue;
            equalSet[i] += nums[index];
            if (divideEqualSet(nums, equalSet, target, index + 1)) {
                return true;
            }
            equalSet[i] -= nums[index];
        }
        return false;
    }
    public void reverse(int[] nums) {
        int begin = 0, end = nums.length - 1;
        while (begin < end) {
            int temp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = temp;
            begin++;
            end--;
        }
    }
}
