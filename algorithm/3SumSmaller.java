/* Two pointers with 2 sum */
public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int res = 0;
        for(int i = 0; i < nums.length-2; i++){
            int begin = i + 1, end = nums.length - 1;
            while(begin < end){
                if(nums[i]+nums[begin]+nums[end] < target){
                    res += (end - begin); /* any number between begin to end are smaller */
                    begin++;
                }else{
                    end--;  /* move end pointer to get smaller number */
                }
            }
        }
        return res;
    }
}
