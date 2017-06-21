/* various input cases that need to consider*/
/*
1. Ignore leading whitespaces until '+', '-' or valid number (ie, "  +123", return 123)
2. Return 0 for leading special characters other than '+', '-', or whitespaces before parsing valid number (ie, "  + 123", return 0)
3. Ignore any ending special characters (ie, 123!*, return 123)
4. Return only the valid part (ie, 123!345, return 123)
5. Return Integer.MAX_VALUE, or Integer.MIN_VALUE if overflows
*/
/* template:
    boolean valid = false; /* indicate valid starting point
    for each char c in str{
        if(Chracter.isDigit(c)){    /* valid chars part
            valid = true;
            //handle valid chars, overflows
        }else{                      /* invalid special chars part
            //handle special
            if(!valid){             /* if not has a valid starting point
                // two case: leading whitespaces, "+", "-" sign
            }else{                  /* if has a valid starting point
                break;
            }
        }
    }

*/
public class Solution {
    public int myAtoi(String str) {
        if(str.length() == 0) return 0;
        int sign;
        int result = 0;
        boolean valid = false;
        for(int i = 0; i < str.length(); i++){
            if(Character.isDigit(str.charAt(i))){ /* deal with number */
                valid = true;
                int num = str.charAt(i) - '0';
                /* avoiding interger overflow */
                if(Integer.MAX_VALUE / 10 < result  || (Integer.MAX_VALUE - num) < result * 10){
                    return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                result = result * 10 + num;
            }else{ /* deal with other characters */
                if(!valid){
                    if(str.charAt(i) == ' '){ /* ignoring leading whitespaces */
                        continue;
                    }else if(str.charAt(i) == '-') {
                        valid = true;
                        sign = -1;
                        continue;
                    }else if(str.charAt(i) == '+'){
                        valid = true;
                        sign = 1;
                        continue;
                    }else{
                        return 0; /* return 0 for any leading special characters except '+', '-' */
                    }
                }else{
                    break; /* we have evaluated something, ignoring ending special scharacters */
                }
            }
        }
        return sign * result;
    }
}
