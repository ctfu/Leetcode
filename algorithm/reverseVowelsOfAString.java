/* Approach: two pointers from both end */
public class Solution {
    public String reverseVowels(String s) {
        if(s == null || s.length() == 0) return s;
        String vowels = "aeiouAEIOU"; /* create a vowels dictionary */
        int begin = 0;
        int end = s.length()-1;
        char[] strArr = s.toCharArray();/* because string is unmutable, convert to char array */
        while(begin < end){
            while(begin < end && !vowels.contains(strArr[begin]+"")){
                begin++;
            }
            while(begin < end && !vowels.contains(strArr[end]+"")){
                end--;
            }
            if(begin < end){
                char temp = strArr[begin];
                strArr[begin] = strArr[end];
                strArr[end] = temp;
                begin++;
                end--;
            }
        }
        return new String(strArr);
    }
}
