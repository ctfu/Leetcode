public class Solution {
    public String toHex(int num) {
        if(num == 0) return "0";
        char[] hexValue = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                            'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder res = new StringBuilder();
        long lnum = num;
        if(lnum < 0){
            lnum = (1L<<32) + lnum;     //to get positive representation of negetive number
        }
        while(lnum != 0){
            res.append(hexValue[(int)(lnum % 16)]);
            lnum /= 16;
        }
        return res.reverse().toString();
    }
}
