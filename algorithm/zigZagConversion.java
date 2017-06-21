/* use StringBuilder[numRows] for each row of converted zigZagp string, and merge all together */
public class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 0) return null;
        if(numRows == 1) return s;

        char[] c = s.toCharArray();
        int len = c.length;
        StringBuffer[] sb = new StringBuffer[numRows];  //using StringBuffer
        for(int i = 0; i < numRows; i++) sb[i] = new StringBuffer();

        int i = 0;
        while(i < len){
            for(int j = 0; j < numRows && i < len; j++){    //going row down
                sb[j].append(c[i++]);
            }
            /* because the numRows is starting from 1 */
            for(int j = numRows - 2; j >= 1 && i < len; j--){   //going row up
                sb[j].append(c[i++]);
            }
        }
        for(i = 1; i < sb.length; i++){
            sb[0].append(sb[i]); /* append each stringBuilder to sb[0] */
        }
        return sb[0].toString();
    }
}
