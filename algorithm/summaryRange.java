/* Approach: Two pointer */
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        int begin = 0, end = 0;
        while (end < nums.length - 1) {
            if (nums[end + 1] == nums[end] + 1) {
                end++;
            } else {
                if (begin != end) {
                    String range = nums[begin] + "->" + nums[end];
                    res.add(range);
                } else {
                    res.add(nums[end] + "");
                }
                end++;
                begin = end;
            }
        }
        // deal with the rest because of the while loop condition 
        if (begin != end) {
            String range = nums[begin] + "->" + nums[end];
            res.add(range);
        } else {
            res.add(nums[end] + "");
        }
        return res;
    }
}
