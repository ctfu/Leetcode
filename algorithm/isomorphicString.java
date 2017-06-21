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

/* second solution */
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Object, Object> hm = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(!Objects.equals(hm.put(s.charAt(i), i), hm.put(t.charAt(i) + "", i))){
                return false;
            }
        }
        return true;
    }
}

/* third solution */
public boolean isIsomorphic(String s, String t) {
    int[] cache = new int[256];
    int[] cache1 = new int[256];
    for(int i = 0; i < s.length(); i++){
        if(cache[s.charAt(i)] != cache1[t.charAt(i)]){
            return false;
        }
        cache[s.charAt(i)] = i + 1;
        cache1[t.charAt(i)] = i + 1;
    }
    return true;
}
