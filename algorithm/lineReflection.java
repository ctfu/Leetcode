/* 找出对称线使得所有点关于这个条对称 *／
／* Technique: Obtain the minimum and maximum x point out of all the points */
class Solution {
    public boolean isReflected(int[][] points) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Set<String> set = new HashSet<>();
        for (int[] p : points) {
            min = Math.min(min, p[0]);
            max = Math.max(max, p[0]);
            String encoded = p[0] + "p" + p[1];
            set.add(encoded);
        }
        int sum = min + max;
        for (int[] p : points) {
            String encoded = (sum - p[0]) + "p" + p[1];
            if (!set.contains(encoded)) {
                return false;
            }
        }
        return true;
    }
}
