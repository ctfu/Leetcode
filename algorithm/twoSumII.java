public class Solution {
  //input array is sorted
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        for(int i = numbers.length-1; i > 0; i--){
            res[1] =i + 1;
            int j = search(numbers, i, target - numbers[i]);
            if(j >= 0){
                res[0] = j + 1;
                break;
            }
        }
        return res;
    }

    private int search(int[] nums, int position, int target){
        int small = 0;
        int big = position -1;
        while(small <= big){
            int mid = small + (big-small) /2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                big = mid -1;
            }else{
                small = mid  + 1;
            }
        }
        return -1;
    }
}

/* the second solution using two pointers */
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int start = 0;
        int end = numbers.length -1;
        while(start < end){
            int sum = numbers[start] + numbers[end];  /*should cast the result to long, incase of integer overflow */
            if(sum == target){
                res[0] = start + 1;
                res[1] = end + 1;
                break;
            }else if(sum > target){
                end--;
            }else{
                start++;
            }
        }
        return res;
    }
}
