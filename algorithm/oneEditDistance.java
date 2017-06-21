/* 3 possible ways to edit a string once:
 * 1. replace
 * 2. delete a char from s
 * 3. delete a char form t */
public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        for(int i = 0; i < Math.min(s.length(), t.length()); i++){
            if(s.charAt(i) != t.charAt(i)){
                if(s.length() == t.length()){
                    return s.substring(i+1).equals(t.substring(i+1)); /* replace operation */
                }else{
                    if(s.length() < t.length()){
                        return s.substring(i).equals(t.substring(i+1)); /* delete a word from t */
                    }else{
                        return s.substring(i+1).equals(t.substring(i)); /* delete a word from s */
                    }
                }
            }
        }
        /* if all previous conditions are true, the only possibile left is, deleting one char from the longer string */
        return Math.abs(s.length()-t.length()) == 1;
    }
}
