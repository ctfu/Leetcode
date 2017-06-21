/* Approach: recursive */
public class Solution {
    public String countAndSay(int n) {
       return countAndSayHelper(n, "1");
    }
    private String countAndSayHelper(int n, String init){
        if(n == 1){ /* base case, n represents nth string */
            return init;
        }
        String next = genNext(init);
        return countAndSayHelper(n-1, next);
    }
    private String genNext(String init){
        StringBuilder sb = new StringBuilder();
        int count = 1;  /* initialize count = 1 */
        for(int i = 0; i < init.length()-1; i++){
            if(init.charAt(i) == init.charAt(i+1)){
                count++;
            }else{
                sb.append(count);
                sb.append(init.charAt(i));
                count = 1;
            }
        }
        sb.append(count);
        sb.append(init.charAt(init.length()-1));
        return sb.toString();
    }
}
