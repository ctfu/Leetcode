/* Approach 1: brute force
 * time complexity: O(n^2) */
 public class Solution {
     public boolean checkSubarraySum(int[] nums, int k) {
         if (nums == null || nums.length < 2) {
             return false;
         }
         int sum = 0;
         for (int i = 0; i < nums.length - 1; i++) {
             sum = nums[i];
             for (int j = i + 1; j < nums.length; j++) {
                 sum += nums[j];
                 if (sum == k || k != 0 && sum % k == 0) {
                     return true;
                 }
             }
         }
         return false;
     }
 }

/* Approach 2: HashMap - similar problem: Leetcode 525 Contiguous Subarray
 * Time complexity: O(n), space complexity: O(min(n, k)) */
 public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums == null || nums.length < 2) return false;

        Map<Integer, Integer> hm = new HashMap<>();
        /* the reason to put(0, -1) is to calculate the size when from the begining */
        hm.put(0, -1);
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i]; /* accumulated sum */
            if(k != 0){
                sum = sum % k;
            }
            if(hm.containsKey(sum)){
                if(i - hm.get(sum) > 1){
                    return true;
                }
            }else{
                hm.put(sum, i); /* key: sum remainder, value: index */
            }
        }
        return false;
    }
}
