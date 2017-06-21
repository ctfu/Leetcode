/* Recursion: recursivly build the number from both end to the center
 * each time reduce size two */
public class Solution {
    public List<String> findStrobogrammatic(int n) {
        return findNumber(n, n);
    }
    /* n is the current num size, m is the original size, to deal with 00 cases */
    public List<String> findNumber(int n, int m){
        List<String> res = new ArrayList<>();
        if(n == 0){
            res.add("");/* a list with empty string */
            return res;
        }
        if(n == 1){
            res.addAll(Arrays.asList("0","1","8"));
            return res;
        }

        List<String> list = findNumber(n-2, m);
        for(String s : list){
            if(n != m) res.add("0"+s+"0");/* "00" pair could exist if it is inside a number */
            res.add("1"+s+"1");
            res.add("8"+s+"8");
            res.add("6"+s+"9");
            res.add("9"+s+"6");
        }
        return res;
    }
}
