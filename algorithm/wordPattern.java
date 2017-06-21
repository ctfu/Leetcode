/* Question requirements:
 * 1. Assume pattern and str contain only lower case letters
 * 2. Assume str is seperated by a single space " " */
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        Map<Object, Object> hm = new HashMap<>();
        String[] words = str.split(" ");
        if(pattern.length() != words.length){
            return false;
        }
        for(int i = 0; i < pattern.length(); i++){
            /* using Objects.equals() to compare with objects */
            if(!Objects.equals(hm.put(pattern.charAt(i), i), hm.put(words[i], i))){
                return false;
            }
        }
        return true;
    }
}
