public class Solution {
    public String reverseStr(String s, int k) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int index = 0;
        char[] str = s.toCharArray();
        while (index < str.length) {
            if ((index + 2 * k) < str.length) {
                reverse(str, index, index + k);
                index += 2 * k;
            } else if (index + k < str.length) {
                reverse(str, index, index + k);
                index += k;
                break;
            } else {
                reverse(str, index, str.length);
                break;
            }
        }
        return new String(str);
    }

    public void reverse(char[] str, int i, int j) {
        int begin = i, end = j - 1;
        while (begin < end) {
            char temp = str[begin];
            str[begin] = str[end];
            str[end] = temp;
            begin++;
            end--;
        }
    }
}

/* shorter one */
public class Solution {
    public String reverseStr(String s, int k) {
        int len = s.length();
        char[] res = s.toCharArray();
        int begin = 0;
        while(begin < len){
            int j = Math.min(begin+k-1, len-1); /* major step */
            reverse(res, begin, j);
            begin += 2*k;
        }
        return new String(res);
    }
    public void reverse(char[] str, int begin, int end){
        while(begin < end){
            char temp = str[begin];
            str[begin] = str[end];
            str[end] = temp;
            begin++;
            end--;
        }
    }
}
