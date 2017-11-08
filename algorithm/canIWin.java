class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) {
            return false;
        }
        int[] state = new int[maxChoosableInteger + 1];
        return canWin(state, desiredTotal, new HashMap<String, Boolean>());
    }

    public boolean canWin(int[] state, int total, Map<String, Boolean> hmap) {
        String key = Arrays.toString(state);
        if (hmap.containsKey(key)) {
            return hmap.get(key);
        }
        for (int i = 1; i < state.length; i++) {
            if (state[i] == 0) {
                state[i] = 1;
                if (total - i <= 0 || !canWin(state, total - i, hmap)) {
                    hmap.put(key, true);
                    state[i] = 0;
                    return true;
                }
                state[i] = 0;
            }
        }
        hmap.put(key, false);
        return false;
    }
}
