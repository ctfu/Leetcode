/* Note:
 * 1. a number in the abbr indicates how many character are going to skip
 * 2. the number can't be leading zeros or single zero itself */
public class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        if(word.length() < abbr.length()) return false;
        int index = 0;
        int skip = 0;
        int i;
        for(i = 0; i < abbr.length(); i++){
            char c = abbr.charAt(i);
            if(Character.isDigit(c)){ /* if digit */
                skip = skip * 10 + c-'0'; /* accumulate the continious number */
                if(skip == 0) break; /* if it is a single 0, or leading 0 by itself, such as ["ab","02"] */
            }else{  /* if character */
                index += skip;
                skip = 0; /* important to reset skip */
                if(index < word.length() && word.charAt(index) == abbr.charAt(i)){/* check bound */
                    index++;
                }else{
                    break;
                }
            }
        }
        return index + skip == word.length() && i == abbr.length();
    }
}
