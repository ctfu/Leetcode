public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if(words.length == 0 || s.length() < words.length * words[0].length()){
            return res;
        }
        /* hm for words look up, tempMap for valid word appear in s */
        Map<String, Integer> hm = new HashMap<>(), tempMap = new HashMap<>();
        for(String str : words){
            if(hm.containsKey(str)){
                hm.put(str, hm.get(str) + 1);
            }else{
                hm.put(str, 0);
            }
        }
        int wl = words[0].length();
        for(int i = 0; i < wl; i++){
            int counter = 0;
            for(int l = i, r = i; r + wl <= s.length(); r += wl){
                String str1 = s.substring(r, r + wl);
                if(hm.containsKey(str1)){
                    if(tempMap.containsKey(str1)){
                        tempMap.put(str1, tempMap.get(str1) + 1);
                    }else{
                        tempMap.put(str1, 0);
                    }
                    if(tempMap.get(str1) <= hm.get(str1)) counter++;
                    /* if current word reapeating, any word start from begin will not possible to
                     * consititute all concatenation of all words, so move begin pointer */
                    while(tempMap.get(str1) > hm.get(str1)){/* valid words repeating */
                        String temp = s.substring(l, l + wl);
                        tempMap.put(temp, tempMap.get(temp) - 1);
                        l += wl;
                        /* could be the second or after repeating, first word is valid but decrement
                         * so counter should decrement */
                        if(tempMap.get(temp) < hm.get(temp)) counter--;
                    }
                    if(counter == words.length){
                        res.add(l);
                        String temp = s.substring(l, l + wl);
                        tempMap.put(temp, tempMap.get(temp) - 1);
                        counter--; /* all words inside the window are valid, when move, should decrement counter */
                        l += wl;
                    }
                }else{
                    tempMap.clear();
                    counter = 0;
                    l = r + wl; /* r + wl, because the word after r is not valid */
                }
            }
            tempMap.clear();
        }
        return res;
    }
}

/* second solution */
public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if(words.length == 0 || s.length() < words.length * words[0].length()){
            return res;
        }
        Map<String, Integer> hm = new HashMap<>(), tempMap = new HashMap<>();
        for(String str : words){
            if(hm.containsKey(str)){
                hm.put(str, hm.get(str) + 1);
            }else{
                hm.put(str, 0);
            }
        }
        int wl = words[0].length();
        int begin = 0, end = 0;
        for(int i = 0; i < wl; i++){
            int counter = 0;
            int windowSize = 0;
            begin = i; end = i;
            while(end + wl <= s.length()){
                String str1 = s.substring(end, end + wl);
                if(hm.containsKey(str1)){
                    if(tempMap.containsKey(str1)){
                        tempMap.put(str1, tempMap.get(str1) + 1);
                    }else{
                        tempMap.put(str1, 0);
                    }
                    if(tempMap.get(str1) <= hm.get(str1)) counter++;
                }
                end += wl;
                windowSize++;
                if(counter == words.length){
                    res.add(begin);
                }
                if(windowSize == words.length){
                    String temp = s.substring(begin, begin + wl);
                    if(hm.containsKey(temp)){
                        /* only ajust the counter if is valid and not duplicated */
                        if(tempMap.get(temp) <= hm.get(temp)) counter--;
                        tempMap.put(temp, tempMap.get(temp)-1);/* reduce the count from tempMap */
                    }
                    begin += wl;
                    windowSize--;
                }
            }
            tempMap.clear();
        }
        return res;
    }
}
