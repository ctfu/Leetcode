class Solution {
    public int distributeCandies(int[] candies) {
        if (candies.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int candy : candies) {
            map.put(candy, map.getOrDefault(candy, 0) + 1);
        }
        // distributed between brother and sister, the objective is to let sister get the most kind of candies//
        return candies.length / 2 > map.size() ? map.size() : candies.length/ 2;
    }
}
