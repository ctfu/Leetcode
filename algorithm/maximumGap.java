/* Variation of bucket sort
suppose there are N numbers in the array, min, max represents the min and max number, then the
minimum gap between two number is no smaller than the Math.ceil((double)(max-min)/(n-1)) */
class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int min = nums[0], max = nums[0];
        for (int num: nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int gap = (int) Math.ceil((double)(max - min) / (nums.length - 1));
        int[] minBucket = new int[nums.length - 1];
        int[] maxBucket = new int[nums.length - 1];
        Arrays.fill(minBucket, Integer.MAX_VALUE);
        Arrays.fill(maxBucket, Integer.MIN_VALUE);
        for (int num : nums) {
            if (num == min || num == max) {
                continue;
            }
            int index = (num - min) / gap;
            minBucket[index] = Math.min(minBucket[index], num);
            maxBucket[index] = Math.max(maxBucket[index], num);
        }
        int maxGap = Integer.MIN_VALUE;
        int previous = min;
        for (int i = 0; i < minBucket.length; i++) {
            if (minBucket[i] == Integer.MAX_VALUE && maxBucket[i] == Integer.MIN_VALUE) {
                continue;
            }
            maxGap = Math.max(maxGap, minBucket[i] - previous);
            previous = maxBucket[i];
        }
        maxGap = Math.max(maxGap, max - previous); // dont forget the max number
        return maxGap;
    }
}
