/*
A zero-indexed array A of length N contains all integers from 0 to N-1.
Find and return the longest length of set S, where
S[i] = {A[i], A[A[i]], A[A[A[i]]], ... } subjected to the rule below.

Suppose the first element in S starts with the selection of element A[i]
of index = i, the next element in S should be A[A[i]], and then A[A[A[i]]]…
By that analogy, we stop adding right before a duplicate element occurs in S.

Example 1:

Input: A = [5,4,0,3,1,6,2]
Output: 4
Explanation:
A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.

One of the longest S[K]:
S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
*/
/* Method 1: using extra space to prevent calculations in cycle */
public class Solution {
    public int arrayNesting(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            // I think the set should be place here, since the longest one may
            // not start at the first index, we need a new set for each try
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
