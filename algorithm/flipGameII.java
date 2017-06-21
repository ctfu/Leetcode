/* Backtracking: try one move (flip "++" => "--")
 * 1. recursive, and if second player can win, retore the "--" back to "++", try next move 
 * 2. recursive, if second player can't win, retun true */
public class Solution {
    public boolean canWin(String s) {
        if(s == null || s.length() == 0) return false;
        char[] str = s.toCharArray();
        return win(str);
    }
    public boolean win(char[] str){
        for(int i = 0; i < str.length-1; i++){
            if(str[i] == '+' && str[i+1] == '+'){
                str[i] = '-';
                str[i+1] = '-';
                boolean isWin = win(str);
                str[i] = '+';
                str[i+1] = '+';
                if(!isWin) return true; /* before return, need to restore */
            }
        }
        return false;
    }
}
