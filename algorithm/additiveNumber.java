/* try the possibility of first number and second number
* the rule is that the sum result of first and second number should no less then the length of bigger number
* so i is up to num.length() / 2 and sum.length() - i - j >= Math.max(i, j) */
class Solution {
    public boolean isAdditiveNumber(String num) {
        if (num.length() < 3) {
            return false;
        }
        for (int i = 1; i <= num.length() / 2; i++) {
            if (num.charAt(0) == '0' && i > 1) {
                return false;
            }
            Long first = Long.valueOf(num.substring(0, i));
            for (int j = 1; num.length() - i - j >= Math.max(i, j); j++) {
                if (num.charAt(i) == '0' && j > 1) {
                    break;
                }
                Long second = Long.valueOf(num.substring(i, i + j));
                if (isValid(first, second, i + j, num)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isValid(Long first, Long second, int start, String num) {
        if (start == num.length()) {
            return true;
        }
        second = second + first;
        first = second - first;
        String sum = second.toString();
        return num.startsWith(sum, start) && isValid(first, second, start + sum.length(), num);
    }
}
