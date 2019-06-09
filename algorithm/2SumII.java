Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.

Note:

Your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution and you may not use the same element twice.
Example:

    Input: numbers = [2,7,11,15], target = 9
    Output: [1,2]
    Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
--------------------------------------------------------------------------------
/* the second solution using two pointers */
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int start = 0;
        int end = numbers.length -1;
        while(start < end){
            int sum = numbers[start] + numbers[end];  /*should cast the result to long, incase of integer overflow */
            if(sum == target){
                res[0] = start + 1; /* the starting index is from 1 */
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
