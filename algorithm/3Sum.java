/* Note: return unique set, need to remove duplicates */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 3) return res;
        Arrays.sort(nums);/* remember to sort the array */
        for(int i = 0; i < nums.length-2; i++){
            if(i == 0 || i > 0 && nums[i] != nums[i-1]){/* reduce duplicate at 3rd level */
                int begin = i+1, end = nums.length-1, target = 0-nums[i];
                while(begin < end){
                    if(nums[begin] + nums[end] == target){
                        res.add(Arrays.asList(nums[i], nums[begin], nums[end]));
                        /* reduce the duplcate in 2ed level */
                        while(begin < end && nums[begin] == nums[begin+1]) begin++;
                        while(begin < end && nums[end] == nums[end-1]) end--;
                        begin++;
                        end--;
                    }else if(nums[begin] + nums[end] < target){
                        begin++;
                    }else{
                        end--;
                    }
                }
            }
        }
        return res;
    }
}
