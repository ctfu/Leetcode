//Instead of 1 -> A, 26 -> Z, we can assume that 0 -> A, 25 -> Z, and then here comes the base 26 representation
public class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while(n != 0){
            n--;
            char c = (char)(n % 26 + 'A');
            sb.append(c);
            n /= 26;
        }
        return sb.reverse().toString();
    }
}

/* if A is starting from 0, then */
public class Solution {
    public String convertToTitle(int n) {
        n++;    /* first transform to A starts from 1 */
        StringBuilder sb = new StringBuilder();
        while(n != 0){
            n--;
            char c = (char)(n % 26 + 'A');
            sb.append(c);
            n /= 26;
        }
        return sb.reverse().toString();
    }
}
