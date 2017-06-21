/* Regular expression */
public class Solution {
    public boolean detectCapitalUse(String word) {
        /* '|' indicates or */
        return word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+");
    }
}
/* Method 2 */
public class Solution{
    public boolean detectCaptialUse(String word){
        if(word.length() <= 1) return true;
        if(word.toUpperCase().equals(word)) return true; /* either all upper case */
        if(word.subString(1).toLowerCase().equals(word.substring(1))) return true;  /* or all lowercase from second to end */
        return false;
    }
}
