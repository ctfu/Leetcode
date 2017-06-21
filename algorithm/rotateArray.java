/* Method 1: shifting element */
public class Solution {
    public void rotate(int[] nums, int k) {
        int count = 0;
        while(count < k){
            int temp = nums[nums.length -1];
            /* shift the element to the right */
            for(int i = nums.length -1; i > 0; i--){
                nums[i] = nums[i-1];
            }
            nums[0] = temp;
            count++;
        }
    }
}

/*second logic
Let the array be - 123456789 and k = 4

Step 1 - 12345 6789 ---> 54321 6789

Step 2 - 54321 6789 ---> 54321 9876

Step 3 - 543219876 ---> 678912345 */

public class Solution {
    public void rotate(int[] nums, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        int len = nums.length;
        for(int i = 0; i < len; i++){
            int position;
            if(k > nums.length){
                position = len - Math.abs(len -k);
            }else{
                position = len - k;
            }
            if(i < position){
                list.add(0, nums[i]);
            }else{
                list.add(position, nums[i]);
            }
        }
        for(int i = 0; i < len; i++){
            nums[i] = list.get(len-1 - i);
        }
    }
}

/* Method 2: reverse */
/* a nicer in-place solution based on above logic*/
public class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length; /* this one importatn because k could be greater than nums.length*/
        reverse(nums, 0, nums.length -1);/* reverse the entire array first */
        reverse(nums, 0, k -1);
        reverse(nums, k, nums.length -1);
    }
    private void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
