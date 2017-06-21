/* The formula is G(i) = i ^ i>>1 */
public class Solution {
    /* input n represents number of bits in the code */
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < 1<<n; i++){ /* 1 leftshit n bit */
            res.add(i ^ i>>1); /* apply the formula */
        }
        return res;
    }
}
