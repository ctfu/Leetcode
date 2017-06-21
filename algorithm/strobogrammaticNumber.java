/* Note: For a number to be strobogrammatic(upside down the same), they must appear in pairs
 * and must be among pairs of [00, 11, 88, 69, 96] */

/* Method 1: HashMap store pairs and check for valid key */
public class Solution {
    public boolean isStrobogrammatic(String num) {
        if(num == null || num.length() == 0) return true;
        Map<Character, Character> hm = new HashMap<>();
        hm.put('0', '0');
        hm.put('1', '1');
        hm.put('8', '8');
        hm.put('6', '9');
        hm.put('9', '6');
        int begin = 0, end = num.length()-1;
        /* reason begin <= end, because we also want to check the very middle number's strobogrammatic
         * unlike reverse swap, or palindrom or two sum, where not necessary to check the mid */
        while(begin <= end){
            if(!hm.containsKey(num.charAt(begin))){ /* if is other number character */
                return false;
            }else if(hm.get(num.charAt(begin)) != num.charAt(end)){
                return false;
            }else{
                begin++;
                end--;
            }
        }
        return true;
    }
}
/* Method 2: without HashMap (check each pair,since only have 5 pairs) */
public class Solution {
    public boolean isStrobogrammatic(String num) {
        if(num == null || num.length() == 0) return true;
        int begin = 0, end = num.length()-1;
        while(begin <= end){
            if(checkPair(num.charAt(begin), num.charAt(end))){
                begin++;
                end--;
            }else{
                return false;
            }
        }
        return true;
    }
    private boolean checkPair(char a, char b){
        if(a=='1' && b=='1' || a=='0'&& b=='0' || a=='8'&& b=='8' || a=='6'&& b=='9' || a=='9'&& b=='6'){
            return true;
        }
        return false;
    }
}
