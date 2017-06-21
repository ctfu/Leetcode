/* 1. Find the largest index k such that nums[k] < nums[k + 1]. If no such index exists,
 * the permutation is sorted in descending order, just reverse it to ascending order and we are done.
 * For example, the next permutation of [3, 2, 1] is [1, 2, 3].
 * 2. Find the largest index l greater than k such that nums[k] < nums[l].
 * 3. Swap the value of nums[k] with that of nums[l].
 * 4. Reverse the sequence from nums[k + 1] up to and including the final element nums[nums.size() - 1].*/

public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length < 2) return;
        int s = -1;
        for(int i = nums.length - 1; i > 0; i--){
            if(nums[i] > nums[i-1]){
                s = i - 1;
                break;
            }
        }
        if(s == -1){
            reverse(nums, 0, nums.length - 1);
            return;
        }
        for(int i = nums.length - 1; i > s; i--){
            if(nums[i] > nums[s]){
                int temp = nums[i];
                nums[i] = nums[s];
                nums[s] = temp;
                break;
            }
        }
        reverse(nums, s + 1, nums.length - 1);
    }
    private void reverse(int[] nums, int begin, int end){
        while(begin < end){
            int temp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = temp;
            begin++;
            end--;
        }
    }
}
