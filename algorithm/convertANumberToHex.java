/* to find the negative of a number, it is essentially subtrating that num from 0
 * which is essentially inverting all its bits and add one */

 /* It's not a bug. In n >> m, it only looks at the last five bits of m - so any number greater
 than 31 will be reduced to that number mod 32. So, (256 >> 37) == 8 is true.
This is true if you're working with ints. If it's longs, then it looks at the last
six bits of m, or mods by 64. */
public class Solution {
    public String toHex(int num) {
        if(num == 0) return "0";
        char[] hexValue = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                            'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder res = new StringBuilder();
        long lnum = num;
        if(lnum < 0){
            /* L to indicate long, sets everthing after 32bit to 0*/
            lnum = (1L<<32) + lnum;     //to get positive representation of negetive number
        }
        while(lnum != 0){
            res.append(hexValue[(int)(lnum % 16)]);
            lnum /= 16;
        }
        return res.reverse().toString();
    }
}
