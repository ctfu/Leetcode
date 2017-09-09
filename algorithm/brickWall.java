/* Approach: HashMap
* To calculate the assigned gap, we can accumulate the width of each brick one each row for hash map key
* so that we will have a counter of same width of brick each row (brick gap), we take the second max number
* of gaps, substract from rows. (becase the wall is rectangle, so the max number is the right edge) */
class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < wall.size(); i++) {
            int sumOfDist = 0;
            for (int j = 0; j < wall.get(i).size(); j++) {
                sumOfDist += wall.get(i).get(j);
                hm.put(sumOfDist, hm.getOrDefault(sumOfDist, 0) + 1);
            }
        }
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int num : hm.values()) {
            if (num >  max) {
                secondMax = max;
                max = num;
            } else if (num > secondMax) {
                secondMax = num;
            }
        }
        return secondMax == Integer.MIN_VALUE ? wall.size() : wall.size() - secondMax;
    }
}
