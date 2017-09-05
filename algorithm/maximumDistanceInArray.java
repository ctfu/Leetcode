/* pick two elements from two different arrays out of m arrays */
class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        if (arrays.size() == 0) {
            return 0;
        }
        int min = arrays.get(0).get(0), max = arrays.get(0).get(arrays.get(0).size() - 1);
        int res = Integer.MIN_VALUE;
        // to guarrantee two elements are from different arrays, we start loop through second arrays
        // and calculate the distance from both end */
        for (int i = 1; i < arrays.size(); i++) {
            res = Math.max(res, Math.abs(max - arrays.get(i).get(0)));
            res = Math.max(res, Math.abs(arrays.get(i).get(arrays.get(i).size() - 1) - min));
            max = Math.max(max, arrays.get(i).get(arrays.get(i).size() - 1));
            min = Math.min(min, arrays.get(i).get(0));
        }
        return res;
    }
}
