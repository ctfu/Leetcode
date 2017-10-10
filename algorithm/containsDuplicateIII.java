/* use Tree to maintain a k window and find nums[i], nums[j] within the window */
/* the solution that handles overflow */
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    	if (nums.length < 2 || k == 0) {
    		return false;
    	}
    	TreeSet<Long> set = new TreeSet<>();/* using Long to prevent integer overflow [-1, 2147483647] k = 1, t =2147483647 */

        for (int i = 0; i < nums.length; i++) {
            Long floor = set.floor((long)nums[i]);
            Long ceiling = set.ceiling((long)nums[i]);
            if (floor != null && nums[i] - floor <= t || ceiling != null && ceiling - nums[i] <= t) {
                return true;
            }
            set.add((long)nums[i]);
            if (i >= k) {
                set.remove((long)nums[i - k]); // remove the first number in the k window   
            }
        }
        return false;
    }
}
