public class Solution {
    public int findNthDigit(int n) {
        int len = 1;
		long count = 9;
		int start = 1;

		while (n > len * count) {
			n -= len * count;
			len += 1;
			count *= 10;
			start *= 10;
		}
		start += (n-1) / len;
		String numString = Integer.toString(start);
		return Character.getNumericValue(numString.charAt((n-1) % len));
    }
}
