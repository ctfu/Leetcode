public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        StringBuilder builder = new StringBuilder();
        Arrays.sort(strs);
        char[] a = strs[0].toCharArray();
        char[] b = strs[strs.length - 1].toCharArray();
        for(int i = 0; i < a.length; i++){
            if(a[i] == b[i]){
                builder.append(a[i]);
            }else{
                return builder.toString();
            }
        }
        return builder.toString();
    }
}
