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

/* A better o(n), space: o(1) approach, the process is describe below: */
/*******************************************************************************
  {              1,         a[0],    a[0]*a[1],    a[0]*a[1]*a[2],  }--> abrove
  { a[1]*a[2]*a[3],    a[2]*a[3],         a[3],                 1,  }--> below
********************************************************************************/
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int p = 1;
        /* get the abrove array */
        for(int i = 0; i < nums.length; i++){
            res[i] = p;
            p *= nums[i];
        }

        p = 1;
        /* multiple by the below array */
        for(int i = nums.length-1; i >= 0; i--){
            res[i] *= p;
            p *= nums[i];
        }
        return res;
    }
}
