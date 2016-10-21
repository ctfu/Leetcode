public class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> match = new HashMap<Character, Character>();
        for(int i = 0; i < s.length(); i++){
            if(match.get(s.charAt(i)) != null){
                if(match.get(s.charAt(i)) != t.charAt(i)) return false;
            }else{
                if(notUse(match, t.charAt(i))){ //see if t's char is already used
                    match.put(s.charAt(i), t.charAt(i));
                }else{
                    return false;
                }
            }
        }
        return true;
    }
    private boolean notUse(Map<Character, Character> map, char target){
        if(map.containsValue(target)){
            return false;
        }else{
            return true;
        }
    }
}
