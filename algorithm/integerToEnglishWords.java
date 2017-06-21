/* Group the number by thousands (3 digits). You can write a helper function that takes
 * a number less than 1000 and convert just that chunk to words. */
public class Solution {
    /* why LESS_THAN20 is because words like "Eleven", "Twelve", "One Hundred Eleven" ... are spcial words
     * and cann't be constructed by TENS pattern*/
    public final String[] LESS_THAN20 = {"", "One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    public final String[] TENS = {"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    public final String[] THOUSANDS = {"","Thousand","Million","Billion"};

    public String numberToWords(int num) {
        if(num == 0) return "Zero";

        String res = "";
        int count = 0;
        while(num != 0){
            if(num % 1000 != 0){
                res = helper(num%1000) + THOUSANDS[count] + " " + res;
            }
            num /= 1000;
            count++;
        }
        return res.trim();
    }
    private String helper(int num){
        if(num == 0){
            return "";
        }else if(num < 20){
            return LESS_THAN20[num%20] + " ";
        }else if(num < 100){
            return TENS[num/10] + " " + helper(num%10);
        }else{
            return LESS_THAN20[num/100] + " Hundred " + helper(num%100);
        }
    }
}
