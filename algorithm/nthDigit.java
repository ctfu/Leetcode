/* Approach is to find the specific number posiiton containing the digit */
public class Solution {
    public int findNthDigit(int n) {
        int len = 1;      /* starting number length */
		long count = 9;   /* starting number base: [1,9]*/
		int start = 1;    /* the starting number */

		while (n > len * count) { /* substracting digit counts */
			n -= len * count;
			len += 1;    /* get to the next number length */
			count *= 10; /* get to the next number base: [10,90] */
			start *= 10; /* get to the next starign number: 100 */
		}
		start += (n-1) / len; /* get to the destination number */
		String numString = Integer.toString(start); /* covert to numStrng */
		return Character.getNumericValue(numString.charAt((n-1) % len)); /* get the specific digit */
    }
}
