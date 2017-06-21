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
