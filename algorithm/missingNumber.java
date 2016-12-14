public class Solution {
    public int missingNumber(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        Arrays.sort(nums);
        int left = 0, right = nums.length;
        while(left < right){
            int mid = (left + right) / 2;
            if(nums[mid] > mid){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}

/* o(n) solution using xor */
public class Solution {
    public int missingNumber(int[] nums) {
        int res = nums.length;
        for(int i = 0; i < nums.length; i++){
            res ^= i;
            res ^= nums[i];
        }
        return res;
    }
}
