/* the most important thing is to consider whether there is
any zero in the array, how many of zero */
public class Solution {
    public int[] productExceptSelf(int[] nums) {

        int product = 1;      /* get all numbers product except zero */
        boolean zero = false; /* check if there is any zero */
        int zeroCount = 0;    /* count how many zeros */
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                product *= nums[i];
            }else{
                zero = true;
                zeroCount++;
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0 && zero){
                nums[i] = 0;
            }else if(nums[i] != 0 && !zero){
                nums[i] = product / nums[i];
            }else{
                if(zeroCount > 1){
                    nums[i] = 0;
                }else{
                    nums[i] = product;
                }
            }
        }
        return nums;
    }
}
