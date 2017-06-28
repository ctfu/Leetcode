/* Approach 1: since perfect square are: (1, 4, 9, 16 ...) => which can be calculated as : 1 + 3 + 5 + 7 ...
 * substract perfect square from 1 till num == 0
 * time complexity: O(sqrt(n))
 */
public class Solution {
    public boolean isPerfectSquare(int num) {
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }
}

/* Approach 2: Binary search */
public class Solution {
    public boolean isPerfectSquare(int num) {
        int begin = 1, end = num;
        while (begin <= end) {
            long mid = begin + (end - begin) / 2; // remember to cast into long
            if (mid * mid == num) {
                return true;
            } else if (mid * mid > num) {
                end = (int)mid - 1;
            } else {
                begin = (int)mid + 1;
            }
        }
        return false;
    }
}
