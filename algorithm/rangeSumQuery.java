/* Approach is accumulate sum to each number index.
 * The range sum from [i, j], is essentially the same as acccumulatedSum[j] - accumulateSum[i-1] */
public class NumArray {
    private int[] sum;
    public NumArray(int[] nums) {
        if(nums.length > 0){
            sum = new int[nums.length];
            /* create a sum[] to accumulate sum to each index */
            sum[0] = nums[0];
            for(int i = 1; i < nums.length; i++){
                sum[i] = nums[i] + sum[i -1]; /* accumulate step */
            }
        }
    }

    public int sumRange(int i, int j) {
        /* need to check i == 0, in case sum[i-1] out of bound */
        return i == 0 ? sum[j] : sum[j] - sum[i -1]; /* calculating range */
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
