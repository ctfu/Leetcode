/*
Additive number is a string whose digits can form additive sequence.

A valid additive sequence should contain at least three numbers. Except for the
first two numbers, each subsequent number in the sequence must be the sum of the preceding two.

Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.

Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.

Example 1:

Input: "112358"
Output: true
Explanation: The digits can form an additive sequence: 1, 1, 2, 3, 5, 8.
             1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
Example 2:

Input: "199100199"
Output: true
Explanation: The additive sequence is: 1, 99, 100, 199.
             1 + 99 = 100, 99 + 100 = 199
*.
/* try all the possibility of first number and second number
* the rule is that the sum result of first and second number should no less then the length of bigger number
* so i is up to num.length() / 2 and sum.length() - i - j >= Math.max(i, j) */
class Solution {
    public boolean isAdditiveNumber(String num) {
        if (num.length() < 3) {
            return false;
        }
        // the possibility of first number
        for (int i = 1; i <= num.length() / 2; i++) {
            if (num.charAt(0) == '0' && i > 1) {    // no leading zero
                return false;
            }
            Long first = Long.valueOf(num.substring(0, i));
            // the possibility of second number
            for (int j = 1; num.length() - i - j >= Math.max(i, j); j++) { // third number length restriction
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
        String sum = second.toString();//numeric to string
        return num.startsWith(sum, start) && isValid(first, second, start + sum.length(), num);
    }
}
