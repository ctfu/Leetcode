public class Solution {
    //the solution is to cancel out the different
    public int majorityElement(int[] nums) {
        int majority = nums[0], count = 1;
        for(int i = 1; i < nums.length; i++){
            if(count == 0){ /* indicates majority has been cancel out */
                count++;
                majority = nums[i];
            }else if(majority == nums[i]){
                count++;
            }else{
                count--;
            }
        }
        return majority;
    }
}
