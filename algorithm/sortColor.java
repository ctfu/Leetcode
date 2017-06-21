/* two pointers, do twice sorting
* first while loop, put all 0 at the front
* second while loop, put all 1 at the front */
public class Solution {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int begin = 0, end = nums.length-1;
        while(begin < end){
            while(begin < end && nums[begin] == 0) begin++;
            while(begin < end && nums[end] != 0) end--; /* swap only if nums[end] is 0 */
            if(begin < end){
                swap(nums, begin, end);
            }
        }
        /* everything befor begin is 0 at this step, sort 1 and 2*/
        end = nums.length-1;
        while(begin < end){
            while(begin < end && nums[begin] == 1) begin++;
            while(begin < end && nums[end] == 2) end--;
            if(begin < end){
                swap(nums, begin, end);
            }
        }
    }
    private void swap(int[] nums, int begin, int end){
        int temp = nums[begin];
        nums[begin] = nums[end];
        nums[end] = temp;
    }
}
/* Method 2 */
public class Solution {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int begin = 0, end = nums.length-1, i = 0;
        while(i <= end){    /* important here is "<=" */
            if(nums[i] == 0){
                swap(nums, begin, i);
                begin++;
                i++;
            }else if(nums[i] == 2){
                swap(nums, i, end);
                end--;
            }else{
                i++;
            }
        }
    }
    private void swap(int[] nums, int begin, int end){
        int temp = nums[begin];
        nums[begin] = nums[end];
        nums[end] = temp;
    }
}
