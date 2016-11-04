public class Solution {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int first = nums[nums.length-1];
        int second = Integer.MAX_VALUE;
        int third = Integer.MAX_VALUE;
        if(nums.length < 3) return first;
        for(int i = nums.length -2; i >=0; i--){
            if(nums[i] != first){
                second = nums[i];
                break;
            }
        }
        if(second > first){
            return first;
        }
        for(int i = nums.length-3; i>=0; i--){
            if(nums[i] != second){
                third = nums[i];
                break;
            }
        }
        if(third > second){
            return first;
        }
        int min = Math.min(first, second);
        return Math.min(min, third);
    }
}
