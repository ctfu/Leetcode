/* Boyer-Mooer algorithm
 * Finding the number appears more than n/3, there answer will be at most 2 numbers
 */
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        int majority1 = 0, majority2 = 0;
        int count1 = 0, count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            // didn't put count == 0 condition in the front is make majority1, and majority2 assigned to different numbers
            if (majority1 == nums[i]) {
                count1++;
            } else if (majority2 == nums[i]) {
                count2++;
            } else if (count1 == 0) {
                majority1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                majority2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        // Unlike Majorty Element I, 
        // The question don't guarrantee to have majority number, so we need to comfirm it by counting its frequency
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == majority1) {
                count1++;
            } else if (nums[i] == majority2) {
                count2++;
            }
        }
        if (count1 > nums.length / 3) {
            res.add(majority1);
        }
        if (count2 > nums.length / 3) {
            res.add(majority2);
        }
        return res;
    }
}
