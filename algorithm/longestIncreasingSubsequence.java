/* dp[i]: indicates longest increase subsequence based on that the number in index i is the largest num
 * for the current longest increase subsequence
 * dp[i] = Math.max(dp[j]{0<=j<=i-1}) + 1, if nums[j] < nums[i]
 * Goal: Math.max(dp[i](0<=i<n)) */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int longest = 0;
        for(int i = 0; i < nums.length; i++){
            int localMax = 0; /* important to set local max here for each string of index i */
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i] && dp[j] > localMax){ /* optimal substructure condition */
                    localMax = dp[j];
                }
            }
            dp[i] = localMax + 1;
            longest = Math.max(longest, dp[i]);
        }
        return longest;
    }
}

/* Method 2: binarySearch o(nlogn) */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;

        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if(i < 0) i = -(i + 1);
            dp[i] = x;
            if(i == len) len++;
        }

        return len;
    }
}
