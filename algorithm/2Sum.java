/* Question require to return index, if has to use sorting
 * 1. copy the original array
 * 2. use sorting + two pointer to get the two numbers
 * 3. search the numbers in the original array */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for(int i = nums.length -1; i >= 1; i--){
            res[1] = i;
            int j = search(nums, i, target - nums[i]);
            if(j >= 0){
                res[0] = j;
                return res;
            }
        }
        return res;
    }
    private int search(int[] list,int position, int target){
        for(int i = 0; i < position; i++){
            if(target == list[i]){
                return i;
            }
        }
        return -1;
    }
}

//a hashmap Solution o(n), space o(n) */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                res[1] = i;
                res[0] = map.get(target- nums[i]);
                return res;
            }
            map.put(nums[i], i);
        }
        return res;
    }
}
