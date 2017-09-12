/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        boolean eof = false;
        int total= 0;
        char[] temp = new char[4]; // a temp destionation to store the reading
        while (!eof && total <= n) {
            int count = read4(temp);
            if (count < 4) {
                eof = true;
            }
            count = Math.min(count, n - total); //get actual bytes needed to read
            for (int i = 0; i < count; i++) {
                buf[total++] = temp[i];
            }
        }
        return total;
    }
}
