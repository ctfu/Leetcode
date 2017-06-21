/* time complexity is O(n * sizeof(n)) */
public class Solution {
    public int[] countBits(int num) { /* non-negative integer */
        int[] res = new int[num + 1];
        for(int i = 1; i <= num; i++){
            int count = 0;
            int p = i;
            while(p != 0){ /* unsign integer most significant bit is not zero */
                count += (p & 1);
                p = p >>>1; /* unsign right shift */
            }
            res[i] = count;
        }
        return res;
    }
}

/* O(n) solutions, recurrence for this problem is f[i] = f[i / 2] + i % 2 */
public class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for(int i = 1; i <= num; i++){
            res[i] = res[i>>1] + (i&1);
        }
        return res;
    }
}
