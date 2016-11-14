/* various input cases that need to consider*/
/*
1. Ignore leading whitespaces until '+', '-' or valid number (ie, "  +123", return 123)
2. Return 0 for leading special characters other than '+', '-', or whitespaces before parsing valid number (ie, "  + 123", return 0)
3. Ignore any ending special characters (ie, 123!*, return 123)
4. Return only the valid part (ie, 123!345, return 123)
5. Return Integer.MAX_VALUE, or Integer.MIN_VALUE if overflows
*/

public class Solution {
    public int myAtoi(String str) {
        if(str.length() == 0) return 0;
        int sign;
        if(str.contains("-")){
            sign = -1;
        }else{
            sign = 1;
        }

        int result = 0;
        boolean valid = false;
        for(int i = 0; i < str.length(); i++){
            if(Character.isDigit(str.charAt(i))){
                valid = true;
                int num = str.charAt(i) - '0';
                if(Integer.MAX_VALUE / 10 < result  || (Integer.MAX_VALUE - num) < result * 10){
                    return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                result = result * 10 + num;
            }else{
                if(!valid){
                    if(str.charAt(i) == ' '){
                        continue;
                    }else if(str.charAt(i) == '-' || str.charAt(i) == '+'){
                        valid = true;
                        continue;
                    }
                    else{
                        return 0;
                    }
                }else{
                    break;
                }
            }
        }
        return sign * result;
    }
}
