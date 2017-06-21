/* copy array + reverse array + HashMap  */
public class Solution {
    public String[] findRelativeRanks(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        reverse(copy);
        String[] res = new String[nums.length];
        Map<Integer, String> hm = new HashMap<>();
        for(int i = 0; i < copy.length; i++){
            if(i == 0){
                hm.put(copy[i], "Gold Medal");
            }else if(i == 1){
                hm.put(copy[i], "Silver Medal");
            }else if(i == 2){
                hm.put(copy[i], "Bronze Medal");
            }else{
                hm.put(copy[i], (i+1)+"");
            }
        }
        for(int i = 0; i < nums.length; i++){
            res[i] = hm.get(nums[i]);
        }
        return res;
    }
    public void reverse(int[] nums){
        int begin = 0, end = nums.length-1;
        while(begin < end){
            int temp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = temp;
            begin++;
            end--;
        }
    }
}
