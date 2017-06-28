/* Approach: only get the number for multiplication */
public class Solution {
    public String complexNumberMultiply(String a, String b) {
        int i = a.indexOf('+');
        int j = b.indexOf('+');
        int a1 = Integer.parseInt(a.substring(0, i));
        int a2 = Integer.parseInt(a.substring(i + 1, a.length() - 1));
        int b1 = Integer.parseInt(b.substring(0, j));
        int b2 = Integer.parseInt(b.substring(j + 1, b.length() - 1));
        StringBuilder sb = new StringBuilder();
        sb.append(a1 * b1 - a2 * b2);
        sb.append("+");
        sb.append(a1 * b2 + b1 * a2);
        sb.append("i");
        return sb.toString();
    }
}
