/* To reverse the words in string in place */
/* 1. First reverse the whole string
 * 2. reverse word by word */
public class Solution {
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length-1); /* reverse the whole string */
        int begin = 0; /* begin index of each word */
        for(int i = 0; i < s.length; i++){
            if(s[i] == ' '){ /* since each word is seperate by examtly one space */
                reverse(s, begin, i-1);
                begin = i + 1;
            }
        }
        /* reverse the last word, the end of last word doesn't have space,
         * and it handles the corner case when there is only one word */
        reverse(s, begin, s.length -1);
    }
    private void reverse(char[] s, int begin, int end){
        while(begin < end){
            char temp = s[begin];
            s[begin] = s[end];
            s[end] = temp;
            begin++;
            end--;
        }
    }
}
