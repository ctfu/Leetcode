/* Method 1: DFS without memorization */
public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        if(nums == null || nums.length == 0) return 0;
        return findTargetSum(nums, S, 0, 0);
    }
    public int findTargetSum(int[] nums, int S, int sum, int index){
        int res = 0;
        if(index > nums.length || index == nums.length && sum != S) return 0;
        if(index == nums.length && sum == S) return 1;
        res += findTargetSum(nums, S, sum-nums[index], index+1);
        res += findTargetSum(nums, S, sum+nums[index], index+1);
        return res;
    }
}

/* Method 2: DFS with memorization, before returing, save the result before returing */
public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        if(nums == null || nums.length == 0) return 0;
        return findTargetSum(nums, S, 0, 0, new HashMap<String, Integer>());
    }
    public int findTargetSum(int[] nums, int S, int sum, int index, Map<String, Integer> hm){
        int res = 0;
        String encodedString = index+"->"+sum;  /* construct a unique key */
        if(hm.containsKey(encodedString)){
            return hm.get(encodedString);
        }
        if(index > nums.length || index == nums.length && sum != S) return 0;
        if(index == nums.length && sum == S) return 1;
        res += findTargetSum(nums, S, sum-nums[index], index+1, hm);
        res += findTargetSum(nums, S, sum+nums[index], index+1, hm);
        hm.put(encodedString, res); /* store the result */
        return res;
    }
}
