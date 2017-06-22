/* Approach: HashMap to record repeating remainder and its position
 * time complexity: O(logn), space complexity: O(n)
 */
public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0 || denominator == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        if (numerator < 0 ^ denominator < 0) {
            sb.append("-");
        }
        long first = Math.abs((long)numerator);
        long second = Math.abs((long)denominator);
        sb.append(first / second);
        long remainder = first % second;
        if (remainder == 0) {
            return sb.toString();
        }
        sb.append(".");
        Map<Long, Integer> hm = new HashMap<>();
        while (remainder != 0) {
            if (hm.containsKey(remainder)) {
                sb.insert(hm.get(remainder), "(");
                sb.append(")");
                break;
            } else {
                hm.put(remainder, sb.length());
                remainder *= 10;  //remainder multiple by 10 for next operation
                sb.append(remainder / second);
                remainder %= second;
            }
        }
        return sb.toString();
    }
}
