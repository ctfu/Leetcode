/* Method 1 */
public class Solution {
    public boolean containsDuplicate(int[] nums) {
      Arrays.sort(nums);
      for(int i = 0; i < nums.length -1; i++){
          if(nums[i] == nums[i + 1]){
              return true;
          }
      }
      return false;
    }
}
/* Method 2 */
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(hm.containsKey(nums[i])){
                return true;
            }
            hm.put(nums[i], i);
        }
       return false;
    }
}
