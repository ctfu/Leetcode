public class Solution {
    //4 → 16 → 37 → 58 → 89 → 145 → 42 → 20 → 4
    public boolean isHappy(int n) {
        if(n == 1) return true;
        if(n == 4) return false;
        int sum = 0;
        while(n > 0){
            sum += (int)Math.pow(n % 10, 2);
            n /= 10;
        }
        return isHappy(sum);
    }
}
