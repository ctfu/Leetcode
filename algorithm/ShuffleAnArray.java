public class Solution {
    private int[] nums;
    public Solution(int[] nums) {
        this.nums = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] copy = new int[nums.length];
        System.arraycopy(nums, 0, copy, 0, nums.length);
        for(int i = 1; i < copy.length; i++){
            int j = (int)(Math.random() * (i + 1)); /* (i + 1)is to guarantee equal probility of permutation instead of copy.length*/
            int temp = copy[i];
            copy[i] = copy[j];
            copy[j] = temp;
        }
        return copy;
    }
}
