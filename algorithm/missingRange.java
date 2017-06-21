public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        if(nums == null || nums.length == 0){ /* nums is empty */
            if(lower != upper){
                res.add(lower + "->" + upper);
            }else{
                res.add(lower+ "");
            }
            return res;
        }
        /* deal with lower bound */
        if(nums[0] > lower){
            if(lower + 1 == nums[0]){
                res.add(lower + "");
            }else{
                res.add(lower + "->" + (nums[0]-1));
            }
        }
        for(int i = 0; i < nums.length-1; i++){
            /* if not duplicate && the difference is more than one*/
            if(nums[i] != nums[i+1] && nums[i]+1 != nums[i+1]){
                if(nums[i]+1 == nums[i+1]-1){
                    res.add((nums[i]+1) + "");
                }else{
                    res.add((nums[i]+1) + "->" + (nums[i+1]-1));
                }
            }
        }
        /* deal with upper bound */
        if(nums[nums.length-1] < upper){
            if(nums[nums.length-1] + 1 == upper){
                res.add(upper + "");
            }else{
                res.add((nums[nums.length-1] + 1) + "->" + upper);
            }
        }
        return res;
    }
}
