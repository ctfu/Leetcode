public class Solution {
    public boolean isNumber(String s) {
        boolean numberSeen = false;
        boolean dotSeen = false;
        boolean eSeen = false;
        s = s.trim();   /* trim the white space first */
        for(int i = 0; i < s.length(); i++){
            /* Character.isDigit(s.charAt(i)) */
            if('0' <= s.charAt(i) && s.charAt(i) <= '9'){
                numberSeen = true;
            }else if(s.charAt(i) == '.'){
                if(dotSeen || eSeen){ /* dot cannot be after e notation, 1e+10 => 1 * 10^10, 1e-9 => 1 * 10^-9 */
                    return false;
                }
                dotSeen = true;
            }else if(s.charAt(i) == 'e'){
                /* there must be number before e notation and after e notation, so set numberSeen to false */
                if(eSeen || !numberSeen){
                    return false;
                }
                eSeen = true;
                numberSeen = false;
            }else if(s.charAt(i) == '+' || s.charAt(i) == '-'){/* '+','-'only appears at begining or after e notation */
                if(i != 0 && s.charAt(i-1) != 'e'){
                    return false;
                }
            }else{  /* any other sepcial chars return false */
                return false;
            }
        }
        return numberSeen;
    }
}
