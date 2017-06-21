/* Dynamic programming, HashMap<Integer, Set<Integer>>
 * time complexity: O(n^2), space complexity O(n^2) */
public class Solution {
    public boolean canCross(int[] stones) {
        if (stones.length == 0) {
            return false;
        }
        Map<Integer, Set<Integer>> hm = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            hm.put(stones[i], new HashSet<>());
        }
        hm.get(0).add(0);
        for (int i = 0; i < stones.length; i++) {
            for (int step : hm.get(stones[i])) {
                //next step's valid value range
                for (int nextStep = step - 1; nextStep <= step + 1; nextStep++) {
                    if (nextStep > 0 && hm.containsKey(stones[i] + nextStep)) {
                        hm.get(stones[i] + nextStep).add(nextStep);
                    }
                }
            }
        }
        // if there exist a jump step at the last stone, then it is able to cross river
        return !hm.get(stones[stones.length - 1]).isEmpty();
    }
}
