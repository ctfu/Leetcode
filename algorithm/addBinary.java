public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int carry = 0;
        int aCount = a.length() -1;
        int bCount = b.length() -1;
        int sum = 0;
        while(aCount >= 0 && bCount >= 0){
            int aValue = Character.getNumericValue(a.charAt(aCount));
            int bValue = Character.getNumericValue(b.charAt(bCount));
            sum = aValue + bValue + carry;
            carry = sum / 2;
            res.insert(0, sum % 2); /* always added at the front, so dont need to reverse */
            aCount--;
            bCount--;
        }
        while(aCount >= 0){
            int aValue = Character.getNumericValue(a.charAt(aCount));
            sum = (aValue + carry);
            carry = sum / 2;
            res.insert(0, sum % 2);
            aCount--;
        }
        while(bCount >= 0){
            int bValue = Character.getNumericValue(b.charAt(bCount));
            sum = (bValue + carry);
            carry = sum / 2;
            res.insert(0, sum % 2);
            bCount--;
        }
        if(carry ==  1){    /* remember the last carry */
            res.insert(0, carry);
        }
        return res.toString();
    }
}

/* shorter version */
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int len1 = a.length() - 1, len2 = b.length() - 1;
        int sum = 0, carry = 0;
        while (len1 >= 0 || len2 >= 0) {
            int first = len1 >= 0 ? (a.charAt(len1--) - '0') : 0; // append 0 once one string is finished
            int second = len2 >= 0 ? (b.charAt(len2--) - '0') : 0;
            sum = first + second + carry;
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
