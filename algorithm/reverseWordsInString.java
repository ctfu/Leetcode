public class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] words = s.split("\\s");    /* split s by space: includeing mutiple empty space */
        for(int i = 0; i < words.length; i++){
            if(words[words.length-1-i].length() == 0){ /*check if word is empty, not " "(space)*/
                continue;
            }else{
                sb.append(words[words.length-1-i]);
                sb.append(" ");
            }
        }
        return sb.toString().trim();/* trim the white space from both sides*/
    }
}
