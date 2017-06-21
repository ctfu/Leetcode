/* 1. If repeated with substring pattern, str must be divisible by its substring length
 * 2. Try substring length from half length of str */
public class Solution {
    public boolean repeatedSubstringPattern(String str) {
        if(str == null || str.length() == 0){
            return false;
        }
        /* starting from half length of str */
        for(int i = str.length()/2; i >= 1; i--){
            /* if str length can be divisible by substring length */
            if(str.length()%i == 0){
                int len = str.length()/i; /* calculate number of time need to append s */
                StringBuilder sb = new StringBuilder();
                String s = str.substring(0, i);
                /* build a new string by apending len times */
                for(int j = 0; j < len; j++){
                    sb.append(s);
                }
                if(str.equals(sb.toString())){ /* if new string equals to str, return true */
                    return true;
                }
            }
        }
        return false;
    }
}

/* A small improvement */
public class Solution {
    public boolean repeatedSubstringPattern(String str) {
        if(str == null || str.length() == 0){
            return false;
        }
        for(int i = str.length()/2; i >= 1; i--){
            if(str.length()%i == 0){
                int len = str.length()/i;
                String s = str.substring(0, i);
                int j;
                /* instead of constructing a new string, check if the each j substring equals to s */
                for(j = 1; j < len; j++){
                    if(!s.equals(str.substring(i*j, i*j+i))) break;
                }
                if(j == len){ /* if all j substring match, j reaches to len */
                    return true;
                }
            }
        }
        return false;
    }
}
