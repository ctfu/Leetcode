/* with extra space, HashSet solution, without extra space, the idea is to use some kind of
    hashing to hash the element to its original array. For this question, the number range
    is [1,n], and the index range is [0, n-1], we could hash num[i] to num[i]-1.
    Instead of storing the real hash value, we simply flick the number already in the hash position
    to negative, so that we could retrieve it using Math.abs();*/
public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return res;
        }
        for(int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i]) - 1; /* hashing */
            if(nums[index] < 0){
                res.add(index + 1);
            }
            nums[index] = -nums[index];
        }
        return res;
    }
}
