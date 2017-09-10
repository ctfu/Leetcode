/* Approach: HashMap
* To calculate the assigned gap, we can accumulate the width of each brick one each row for hash map key
* so that we will have a counter of same width of brick each row (brick gap), we take the second max number
* of gaps, substract from rows. (becase the wall is rectangle, so the max number is the right edge) */

/* improve version: dont accumulate the last brick */
class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < wall.size(); i++) {
            int sumOfDist = 0;
            for (int j = 0; j < wall.get(i).size() - 1; j++) { //ignore the last brick
                sumOfDist += wall.get(i).get(j);
                hm.put(sumOfDist, hm.getOrDefault(sumOfDist, 0) + 1);
            }
        }
        int max = Integer.MIN_VALUE;
        for (int num : hm.values()) {
            max = Math.max(max, num);
        }
        // if each row contains one brick, there is no brick gap at all 
        return max == Integer.MIN_VALUE ? wall.size() : wall.size() - max;
    }
}
