public class Solution {
    public boolean wordPattern(String pattern, String str) {
        Map map = new HashMap();
        Integer index = 0;
        String[] elements = str.split(" ");
        if(elements.length != pattern.length()){
            return false;
        }
        for(int i = 0; i < pattern.length(); i++){
            if(map.put(pattern.charAt(i), index) != map.put(elements[i], index)){
                return false;
            }else{
                index++;
            }
        }
        return true;
    }
}
