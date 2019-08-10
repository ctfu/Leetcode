/*
There is a brick wall in front of you. The wall is rectangular and has several
rows of bricks. The bricks have the same height but different width. You want
to draw a vertical line from the top to the bottom and cross the least bricks.

The brick wall is represented by a list of rows. Each row is a list of integers
representing the width of each brick in this row from left to right.

If your line go through the edge of a brick, then the brick is not considered as
crossed. You need to find out how to draw the line to cross the least bricks and
return the number of crossed bricks.
*/
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
        // if each row contains one brick, the map is empty, no gap to draw
        return max == Integer.MIN_VALUE ? wall.size() : wall.size() - max;
    }
}
