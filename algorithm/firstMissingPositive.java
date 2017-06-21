/* 1. Find only first missing positive, skip negative and 0
 * 2. Reconstruct the array that only contains positive number with index matching 0->1, 1->2 ....
 *    Example: 6 should put into nums[5](index 5 slot)
 * 3. Loop through the array and put each number in its corrected above mentioned index by swapping
 * Time compleity O(n) */
public class Solution {
    public int firstMissingPositive(int[] nums) {
        /* each number is at most seened twice, if while loop runs more, outer loop runs less, o(n) */
        for(int i = 0; i < nums.length; i++){
            while(nums[i] > 0 && nums[i] <= nums.length && nums[nums[i]-1] != nums[i]){
                swap(nums, nums[i]-1, i);
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i+1){
                return i+1;
            }
        }
        return nums.length + 1;/* deal with when there is all positive number, or the array is empty */
    }
    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
