/* Approach: depth-first-search
* try each special offers (take or not take the offer), return the min price when take or not take that offer
* when reach the end of the special offer, we need to purchase any-unfinished needs with the original price
* time complexity: O(2^n), space complexity: O(n), the recursion depth*/
public class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return shopping(price, special, needs, 0);
    }
    public int shopping(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int index) {
        if (index == special.size()) {
            return purchaseRemain(needs, price);
        }
        List<Integer> clone = new ArrayList<>(needs);
        int i;
        for (i = 0; i < special.get(index).size() - 1; i++) {
            int diff = needs.get(i) - special.get(index).get(i);
            if (diff < 0) {
                break;
            } else {
                clone.set(i, diff);
            }
        }
        if (i == special.get(index).size() - 1) {
            return Math.min(special.get(index).get(i) + shopping(price, special, clone, index),
                            shopping(price, special, needs, index + 1));
        } else {
            return shopping(price, special, needs, index + 1);
        }
    }
    public int purchaseRemain(List<Integer> needs, List<Integer> price) {
        int sum = 0;
        for (int i = 0; i < needs.size(); i++) {
            sum += needs.get(i) * price.get(i);
        }
        return sum;
    }
}
