/* Backtracking
 * 1. A valid IP address is divided into 4 parts
 * 2. Recursively build each part
 *    1) Each part can has at most 3 chars
 *    2) If the part contains more than 1 chars, can't have leading 0: such as 012
 *    3) Numbers represented by the chars can't be greater than 255 */
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        restoreIp(res, s, new StringBuilder(), 0);
        return res;
    }
    private void restoreIp(List<String> res, String s, StringBuilder sb, int index){
        if(index == 4){ /* we have build previous 4 parts */
            if(s.length() == 0){    /* a valid build should use up all the chars in the string */
                String str = sb.toString();
                res.add(str.substring(0, str.length()-1));/* get rid of the last '.' */
            }
        }else{
            for(int i = 1; i <= 3; i++){    /* recursivly build each part, which contains, 1, 2, or 3 length */
                if(s.length() < i) return;  /* if the string is not enough to build a part with length i */
                String str = s.substring(0, i);
                /* check for leading zero or number greater than 255 */
                if(str.length() > 1 && s.charAt(0) == '0' || Integer.parseInt(str) > 255) continue;
                int len = sb.length();  /* record the cur sb length before go into recursive function */
                sb.append(str);
                sb.append(".");
                restoreIp(res, s.substring(i), sb, index+1);/* reduce s when one part is build */
                sb.setLength(len);  /* when backtracking, restore to the original len */
            }
        }
    }
}
