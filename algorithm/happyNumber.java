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

/* hashmap approach:
 * use hashmap to store already calculate number, if the number appears agian
 * in the hashmap, indicates there is a cycle */
 public class Solution {
    public boolean isHappy(int n) {
        if(n < 1) return false; /* starting with a positive interger */
        Map<Integer, Integer> hm = new HashMap<>();
        int num = n;
        while(num != 1){
            if(hm.containsKey(num)){/* to indicate a cycle */
                return false;
            }
            hm.put(num, -1);/* store the calculated number */
            int sum = 0;
            while(num != 0){
                int digit = num % 10;
                num /= 10;
                sum += digit * digit;/* sum of square of digits */
            }
            num = sum;
        }
        return true;
    }
}
