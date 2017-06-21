/* Note: only flip Consecutive "++" => "--"
 * 1. two '+' must be consecutive
 * 2. No allow to flip from "--" => "++" */
 public class Solution {
     public List<String> generatePossibleNextMoves(String s) {
         List<String> res = new ArrayList<>();
         if(s == null || s.length() == 0) return res;
         char[] str = s.toCharArray();
         for(int i = 0; i < str.length-1; i++){
             if(str[i] == '+' && str[i+1] == '+'){  /* check two consecutive '+' */
                 str[i] = '-';                      /* flip the chars to '-' */
                 str[i+1] = '-';
                 String newWord = new String(str);
                 res.add(newWord);
                 str[i] = '+';                /* restore back to original chars */
                 str[i+1] = '+';
             }
         }
         return res;
     }
 }
