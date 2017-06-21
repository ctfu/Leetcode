/* Method 1: using extra space to prevent calculations in cycle */
public class Solution {
    public int arrayNesting(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int next = nums[i];
            int count = 0;
            while (!set.contains(next)) {
                set.add(next);
                next = nums[next];
                count++;
            }
            res = Math.max(res, count);
        }
        return res;
    }
}

/* Method 2: modified visited value as Integer.MAX_VALUE to get rid of extra space */
public class Solution {
    public int arrayNesting(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != Integer.MAX_VALUE) {
                int next = nums[i];
                int count = 0;
                while (nums[next] != Integer.MAX_VALUE) {
                    int temp = next;
                    next = nums[next];
                    nums[temp] = Integer.MAX_VALUE;
                    count++;
                }
                res = Math.max(res, count);
            }
        }

        return res;
    }
}
