public class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        /* use a hashtable to represent digit lights for hours and minutes */
        int[] nums1 = {8, 4, 2, 1}, nums2 = {32, 16, 8, 4, 2, 1};
        for(int i = 0; i <= num; i++){
            /* assign lights to hours and get hour comboniation time */
            List<Integer> list1 = generateDigit(nums1, i);
            /* assign rest to minutes and get all miniute combonation time */
            List<Integer> list2 = generateDigit(nums2, num - i);
            /* get the valid combonation of these two lists */
            for(int num1 : list1){
                if(num1 > 11) continue;/* hour represet 0-11 */
                for(int num2 : list2){
                    if(num2 >= 60) continue;/* minute represts with 0-59 */
                    res.add(num1 + ":" + (num2 < 10 ? "0" + num2 : num2));
                }
            }
        }
        return res;
    }
    //generate all possible digit for the specified light number
    public List<Integer> generateDigit(int[] num, int count){
        List<Integer> res = new ArrayList<>();
        generateDigitHelper(num, count, 0, 0, res);
        return res;
    }
    //a helper method to permutate the digits
    private void generateDigitHelper(int[] num, int count, int position, int calculated, List<Integer> res){
        if(count == 0){
            res.add(calculated);
        }
        for(int i = position; i < num.length; i++){
            generateDigitHelper(num, count - 1, i + 1, calculated + num[i], res);
        }
    }
}
