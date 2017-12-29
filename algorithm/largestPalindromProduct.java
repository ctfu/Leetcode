/*
n = 2
upperBound = 99 -> generate max number (99 * 99) -> found potential max palindrom
lowerBound = 10

99 * 99 = 9801 -> 9889
*/
class Solution {
    public int largestPalindrome(int n) {
        if (n == 1) {
            return 9;
        }
        int upperBound = (int) Math.pow(10, n) - 1, lowerBound = upperBound / 10 + 1;
        long maxNumber = (long) upperBound * (long) upperBound;
        int half = (int) (maxNumber / (long) Math.pow(10, n));

        boolean foundPalindrom = false;
        long palindrom = 0;
        while (!foundPalindrom) {
            palindrom = createPalindrom(half);
            for (long i = upperBound; i >= lowerBound ; i--) {
                if (i * i < palindrom) {
                    break;
                }
                if (palindrom % i == 0) {
                    foundPalindrom = true;
                    break;
                }
            }
            half--;
        }
        return (int) (palindrom % 1337);
    }

    public long createPalindrom(int n) {
        String pStr = n + new StringBuilder().append(n).reverse().toString();
        return Long.parseLong(pStr);
    }
}
