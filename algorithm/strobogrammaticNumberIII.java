/* 1. Generate all the strobogrammatic number with [len(low), len(high)]
 * 2. count the number only within the range, using str.compareTo(num) to avoid overflow */
public class Solution {
    public int strobogrammaticInRange(String low, String high) {
        int left = low.length(), right = high.length();
        int res = 0;
        for(int i = left; i <= right; i++){
            List<String> nums = findStroboNumber(i, i);
            for(String num : nums){
                /* with same length, num should be lexigraphicaly greater than low
                 * and lexigraphicaly less then high */
                if(num.length()==low.length() && num.compareTo(low) < 0 ||
                        num.length()==high.length()&& num.compareTo(high) > 0) continue;
                res++;
            }
        }
        return res;
    }
    public List<String> findStroboNumber(int m, int n){
        List<String> res = new ArrayList<>();
        if(m == 0){
            res.add("");
            return res;
        }
        if(m == 1){
            res.addAll(Arrays.asList("0","1","8"));
            return res;
        }
        List<String> list = findStroboNumber(m-2, n);
        for(String s : list){
            if(m != n) res.add("0"+s+"0");
            res.add("1"+s+"1");
            res.add("6"+s+"9");
            res.add("9"+s+"6");
            res.add("8"+s+"8");
        }
        return res;
    }
}
