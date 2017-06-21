/* 1. visite the string in reverse order
 * 2. group chars in k group and connected with '-' (StringBuilder) */
public class Solution {
    public String licenseKeyFormatting(String S, int K) {
        Stack<Character> stack = new Stack<>();
        for(char c : S.toCharArray()){
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        int size = 0;
        while(!stack.empty()){
            if(size == K){
                sb.append("-");
                size = 0;
            }
            char c = stack.pop();
            if(c == '-'){
                continue;
            }else if(Character.isLetter(c)){
                sb.append(Character.toUpperCase(c));
                size++;
            }else{
                sb.append(c);
                size++;
            }
        }
        /* the key string can be "--a-a-a-a", preventing leading '-' */
        if(sb.length() != 0 && sb.charAt(sb.length()-1) == '-'){
            sb.setLength(sb.length()-1);
        }
        return sb.reverse().toString();
    }
}

/* improve version */
public class Solution {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        int size = 0;
        for(int i = S.length()-1; i>= 0; i--){ /* no need stack, start string from the end*/
            if(size == K){
                sb.append("-");
                size = 0;
            }
            char c = S.charAt(i);
            if(c == '-'){
                continue;
            }else{
                sb.append(c);
                size++;
            }
        }
        /* check the validness of last char */
        if(sb.length() != 0 && sb.charAt(sb.length()-1) == '-'){
            sb.setLength(sb.length()-1);
        }
        return sb.reverse().toString().toUpperCase(); /* cover letter at the end once */
    }
}
