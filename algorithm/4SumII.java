/* 分治，把4个list，拆成两两组合，降低complexity
* Time complexity: O(n^2), space complexity: O(n^2) */
class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                hm.put(A[i] + B[j], hm.getOrDefault(A[i] + B[j], 0) + 1);
            }
        }
        int res = 0;
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
               res += hm.getOrDefault((C[i] + D[j]) * -1, 0);
            }
        }
        return res;
    }
}
