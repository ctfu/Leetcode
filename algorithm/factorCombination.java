/* backtracking */
class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(result, new ArrayList<Integer>(), n, 2);
        return result;
    }

    public void helper(List<List<Integer>> result, List<Integer> item, int n, int start){
        if (n <= 1) {   // base case: when n is reduced to 1 or below
            if (item.size() > 1) {  // note that size() here should greater 1, can't equal to 1 (which is itself)
                result.add(new ArrayList<Integer>(item));
            }
            return;
        }

        for (int i = start; i <= n; ++i) {
            if (n % i == 0) {
                item.add(i);
                helper(result, item, n/i, i);   // n = n/i
                item.remove(item.size()-1);
            }
        }
    }
}
