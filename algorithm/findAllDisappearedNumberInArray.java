/* similar to Leetcode FindAllDuplicatesInArray, without extra space, using hashing
    as the previous mentioned question, added the numbers, whose position is not been
    hashed. */
public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return res;
        }
        /* flip the numbers in the hashing position */
        for(int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] < 0){
                continue;/* if duplicate, do nothing */
            }
            nums[index] = -nums[index];
        }
        /* find those numbers not been hashed */
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                res.add(i + 1);
            }
        }
        return res;
    }
}
