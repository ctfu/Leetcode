/* monatonic stack problem: increasing stack , o(n), space: o(n) */
public class Solution {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < nums.length; i++){
            if(stack.empty() || nums[stack.peek()] < nums[i]){
                stack.push(i);
            }else{
                return stack.pop();
            }
        }
        if(!stack.empty()){
            return stack.pop();
        }else{
            return 0;
        }
    }
}

/* using binary search approach o(logn), doesnot need to sort */
/* /\/\  cound have multiple peek, this only search for one local peek
   stack finds multiple peek */
public class Solution {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int begin = 0, end = nums.length - 1;
        while(begin < end){
            int mid = begin + (end-begin)/2;
            int midNext = mid + 1;
            if(nums[mid] < nums[midNext]){
                begin = midNext;
            }else{
                end = mid;
            }
        }
        return begin;
    }
}
