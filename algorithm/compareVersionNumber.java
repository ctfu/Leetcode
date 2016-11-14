public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] str1 = version1.split("\\.");
        String[] str2 = version2.split("\\.");
        int i = 0;
        while(i < str1.length || i < str2.length){
            int v1 = i < str1.length ? Integer.parseInt(str1[i]) : 0;
            int v2 = i < str2.length ? Integer.parseInt(str2[i]) : 0;
            if(v1 > v2){
                return 1;
            }else if(v1 < v2){
                return -1;
            }else{
                i++;
            }
        }

        return 0;
    }
}
