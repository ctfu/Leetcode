public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        if(words == null || words.length == 0) return res;
        /* i: previous index of the word
         * k: current index of the word */
        for(int i = 0, k; i < words.length; i = k){
            int len = -1;/* initialize as -1 to attached space for the latter work, such as "I am", " am" is one part */
            for(k = i; k < words.length && len + words[k].length()+1 <= maxWidth; k++){
                len += words[k].length() + 1;   /* default one space for every word */
            }
            int space = 1;  /* intialize as 1 to deal with lines that doesn't take up the whole width(such as last line) */
            int extraSpace = 0;
            StringBuilder sb = new StringBuilder(words[i]);
            if(k != i + 1 && k != words.length){    /* line desn't has only one word or not the last line */
                space = (maxWidth-len)/(k-i-1) + 1; /* plus the original default 1 space */
                extraSpace = (maxWidth-len)%(k-i-1);
            }
            for(int j = i + 1; j < k; j++){
                addSpace(sb, space);
                if(extraSpace-- > 0) addSpace(sb, 1);
                sb.append(words[j]);
            }
            int remainLen = maxWidth - sb.length(); /* if line take up the whole width, remainLen is 0 */
            if(remainLen != 0) addSpace(sb, remainLen);
            res.add(sb.toString());
        }
        return res;
    }
    private void addSpace(StringBuilder sb, int count){
        while(count-- != 0){
            sb.append(" ");
        }
    }
}
