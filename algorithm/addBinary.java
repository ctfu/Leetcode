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
