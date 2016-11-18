/*
1. In the first pass, we XOR all elements in the array, and get the XOR of the two numbers we need to find.
 Note that since the two numbers are distinct, so there must be a set bit (that is, the bit with value '1') in the XOR result.
2. Find out an arbitrary set bit (for example, the rightmost set bit).
3. In the second pass, we divide all numbers into two groups, one with the aforementioned bit set,
another with the aforementinoed bit unset. Two different numbers we need to find must fall into thte two distrinct groups.
XOR numbers in each group, we can find a number in either group.
*/
public class Solution {
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];

        int diff = 0;
        for(int num : nums){
          diff ^= num;    /* get the XOR result */
        }

        diff &= -diff;  /* get the rightmost set bit using two's complement */

        for(int num : nums){
            if((diff & num) == 0){  /* num with unset bit */
                res[0] ^= num;
            }else{                  /* num with set bit */
                res[1] ^= num;
            }
        }
        return res;
    }
}
