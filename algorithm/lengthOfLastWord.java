public class Solution {
    public int lengthOfLastWord(String s) {
        String[] words = s.split(" ");
        if(words.length > 0){ /* if it is not empty: it has word */
            return words[words.length -1].length();
        }
        return 0;
    }
}
