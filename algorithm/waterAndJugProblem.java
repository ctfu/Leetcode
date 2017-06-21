/* Math problem: Bezout lemma
 * Bézout's identity (also called Bézout's lemma) is a theorem in the elementary theory of numbers:
 * let a and b be nonzero integers and let d be their greatest common divisor. Then there exist integers x
 * and y such that ax+by=d. In addition, the greatest common divisor d is the smallest positive
 * integer that can be written as ax + by every integer of the form ax + by is a multiple of the greatest common divisor d. */
public class Solution {
    public boolean canMeasureWater(int x, int y, int z) { /* x, y here is a, b */
        if(x+y < z) return false;   /* the water needs to keep in the jug */
        if(x == z || y == z || x+y == z) return true;
        return z % gcd(x, y) == 0;
    }
    private int gcd(int x, int y){
        if(y == 0) return x;
        return gcd(y, x % y);
    }
}
