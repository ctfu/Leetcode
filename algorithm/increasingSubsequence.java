/* Approach: DFS, calculate number of increasing subsequence
* time complexity: worse case O(2 ^ n), space complexity: O(n)
*/
public class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();   // using set to get rid of duplicate results
        findSub(res, nums, new ArrayList<>(), 0);
        return new ArrayList<>(res);
    }
    public void findSub(Set<List<Integer>> res, int[] nums, List<Integer> tempList, int index) {
        if (tempList.size() > 1) {
            res.add(new ArrayList<>(tempList));
        }
        for (int i = index; i < nums.length; i++) {
            // major condition for deciding increasing subsequence
            if (tempList.size() == 0 || tempList.get(tempList.size() - 1) <= nums[i]) {
                tempList.add(nums[i]);
                findSub(res, nums, tempList, i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
