/* Approach: HashMap */
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> hm = new HashMap<>();
        Stack<String> stack = new Stack<>();
        int minIndex = Integer.MAX_VALUE;
        for (int i = 0; i < list1.length; i++) {
            hm.put(list1[i], i); // transfor string to index
        }
        for (int i = 0; i < list2.length; i++) {
            if (hm.containsKey(list2[i])) {
                if (hm.get(list2[i]) + i == minIndex) {
                    stack.push(list2[i]);
                } else if (hm.get(list2[i]) + i < minIndex) {
                    stack.clear();  // the worst case here could be O(m + n)
                    stack.push(list2[i]);
                    minIndex = hm.get(list2[i]) + i;
                }
            }
        }
        String[] res = new String[stack.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.pop();
        }
        return res;
    }
}
