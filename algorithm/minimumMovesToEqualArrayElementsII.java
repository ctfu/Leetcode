/* if only allow add 1 or subtract 1 from on elelment to make array equal
 * sort the array, and find middle elelment
 * before middle add, after middle subtract, make them equal to middle */
public class Solution {
    public int minMoves2(int[] nums) {
        if(nums.length == 0) return 0;
        Arrays.sort(nums);
        int midIndex = nums.length/2;
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            if(i < midIndex){
                res += nums[midIndex] - nums[i];
            }else if(i > midIndex){
                res += nums[i] - nums[midIndex];
            }
        }
        return res;
    }
}

/* Method 2:
 * Find a point C between A, B to achieve the minimum sum of distance
 * The point will always between A, B
 * dist(A,C) = C-A, dist(C,B) = B-C
 * Sum = B-C+C-A = B-A, so when end points A, B is given, the distance is a constant value,
 * there is no difference to pick any point among A, B,(so can just use A, B themself) */
public class Solution {
    public int minMoves2(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int begin = 0, end = nums.length-1;
        int res = 0;
        while(begin < end){
            res += nums[end]-nums[begin];
            begin++;    /* each time takes care of two end point numbers */
            end--;
        }
        return res;
    }
}
