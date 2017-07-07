/* A variation of the problem "Next Permutation"
* time complexity: O(n), space complexity O(n)
*/
public class Solution {
    public int nextGreaterElement(int n) {
        if (n == 0) {
            return -1;
        }
        String s = String.valueOf(n);
        char[] str = s.toCharArray();

        int k = -1;
        for (int i = str.length - 1; i > 0; i--) {
            if (str[i] > str[i - 1]) {
                k = i - 1;
                break;
            }
        }
        if (k == -1) {
            return -1;
        }
        for (int i = str.length - 1; i > k; i--) {
            if (str[i] > str[k]) {
                char temp = str[i];
                str[i] = str[k];
                str[k] = temp;
                break;
            }
        }
        reverse(str, k + 1, str.length - 1);
        String newStr = new String(str);
        // detect string to integer overflow exception, can also use try ... catch
        /*
        try{
            return Integer.parseInt(newStr);
        } catch (Exception e) {
            return -1;
        } */
        return Long.parseLong(newStr) > Integer.MAX_VALUE ? -1 : (int)Long.parseLong(newStr);
    }

    public void reverse(char[] s, int begin, int end) {
        while (begin < end) {
            char temp = s[begin];
            s[begin] = s[end];
            s[end] = temp;
            begin++;
            end--;
        }
    }
}
