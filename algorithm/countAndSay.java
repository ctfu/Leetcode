public class Solution {
    public String countAndSay(int n) {
       return countAndSayHelper(n, "1");
    }
    private String countAndSayHelper(int n, String init){
        if(n == 1){
            return init;
        }
        String next = genNext(init);
        return countAndSayHelper(n-1, next);
    }
    private String genNext(String init){
        String res = "";
        int count = 1;
        int i = 0;
        for(; i < init.length() - 1; i++){
            if(init.charAt(i) != init.charAt(i +1)){
                res += ("" + count + init.charAt(i));
                count = 1;
            }else{
                count++;
            }
        }
        return res += ("" + count + init.charAt(i)); //add the last element
    }
}
