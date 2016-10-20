public class Solution {
    //all trailing zeros are from 5 * 2.
    //so only count how many 5 factors within n, 2 is implicitly included
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n/5);
    }
}
public class Solution {
    //the brute force solution, which exceeds the time limit
    public int trailingZeroes(int n) {
        int result = 1;
        int count = 0;
        while(count <= n){
            count++;
            result *= count;
        }
        count = 0;
        while(result % 10 == 0){
            count++;
            result /= 10;
        }
        return count;
    }
}
