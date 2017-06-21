/* HashMap: variable count increase when encounter 1, decrease when encounter 0
 * 1. when count becomes 0, indicates we have equal zeros and ones
 * 2. what's more, note that when encounter same count value, we have encounter euqal zeros and ones */
public class Solution {
    public int findMaxLength(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> hm = new HashMap<>();
        int count = 0;
        int max = 0;
        hm.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 1 ? 1 : -1);
            if (hm.containsKey(count)) {
               max = Math.max(max, i - hm.get(count));  /* note that here is not i-hm.get(count) + 1 */
            } else {
                hm.put(count, i);
            }
        }
        return max;
    }
}
