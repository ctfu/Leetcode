/*
The difference between call once and call read multiple times:

The only thing is when you call read4() which reads 4 bytes into your buffer you might read more than you need,
so you want to store those bytes in the buffer, and next time you call read will start from those stored bytes,
 then read more from the file.

Think that you have 4 chars "a, b, c, d" in the file, and you want to call your function twice like this:
read(buf, 1); // should return 'a'
read(buf, 3); // should return 'b, c, d'
All the 4 chars will be consumed in the first call. So the tricky part of this question is
how can you preserve the remaining 'b, c, d' to the second call.
*/

/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    private char[] temp = new char[4];
    private int bufferPtr = 0;
    private int bufferCnt = 0;
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int total = 0;
        while (total < n) {
            if (bufferPtr == 0) {
                bufferCnt = read4(temp);
            }
            if (bufferCnt == 0) {
                break;
            }
            while (total < n && bufferPtr < bufferCnt) {
                buf[total++] = temp[bufferPtr++];
            }
            if (bufferPtr >= bufferCnt) { // reset bufferPtr for the next read
                bufferPtr = 0;
            }
        }
        return total;
    }
}
