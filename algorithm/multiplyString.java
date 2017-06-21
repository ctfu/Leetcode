/* require not to convert to integer and do multiplication *.
/* Approach: each char multiplcation and pos[] array */
public class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];
        for(int i = m-1; i >= 0; i--){
            for(int j = n-1; j >= 0; j--){
                int p1 = i+j, p2 = i+j+1;   /* each multiplication pair index */
                int mul = (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
                int sum = mul + pos[p2];    /* propogate carray */
                pos[p1] += sum / 10;
                pos[p2] = sum % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < pos.length; i++){
            if(!(sb.length() == 0 && pos[i] == 0)){ /* get rid of leading zero */
                sb.append(pos[i]);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
