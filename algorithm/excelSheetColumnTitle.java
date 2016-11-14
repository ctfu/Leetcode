//Instead of 1 -> A, 26 -> Z, we can assume that 0 -> A, 25 -> Z, and then here comes the base 26 representation
public class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while(n != 0){
            char c = numToTitle((n-1) % 26);
            n =  (n-1) / 26;
            sb.insert(0,c);
        }
        return sb.toString();
    }
    private char numToTitle(int n){
       return (char)(n + 'A');
    }
}

//shorter code
public class Solution {
    public String convertToTitle(int n) {
        String res = "";
        while(n != 0){
            char c = (char)((n-1) % 26 + 'A');
            n =  (n-1) / 26;
            res = c + res;
        }
        return res;
    }
}
