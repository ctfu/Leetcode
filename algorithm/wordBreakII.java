/* DFS + HashMap(memorization), the normal backtracking will TLE */
/* time complexity: O(len(dict)^(s/minLenWordInDict))
 * Disadvantage: not good when the dictionary is huge */
public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<String, List<String>> hm = new HashMap<>(); /* using HashMap to memorize the DFS result */
        return breakWord(s, wordDict, hm);
    }
    private List<String> breakWord(String s, List<String> dict, Map<String, List<String>> hm){
        if(hm.containsKey(s)){
            return hm.get(s);
        }
        List<String> res = new ArrayList<>();
        if(s.length() == 0){
            /* add "" to the res to differentiate between the situation:
             * 1. s = abcd, dict = [abc]: after abc, sublist latter return is empty, but abc is not breakable, should not add
             * 2. s = abc,  dict = [abc]: after abc, sublist latter return is emtpy, but abc is breakable, need to add to res,
             * so add "" to make list not empty */
            res.add("");
            return res;
        }
        for(String word : dict){    /* by searching the dictionary */
            if(s.startsWith(word)){
                List<String> sublist = breakWord(s.substring(word.length()), dict, hm);
                for(String sub : sublist){
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
                }
            }
        }
        hm.put(s, res);
        return res;
    }
}

/* Method 2: by operating the string, time complexity with memorization O(n^2), whiout memo: O(2^n) */
public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<String, List<String>> hm = new HashMap<>();
        Set<String> dict = new HashSet<>(wordDict);
        return breakWord(s, dict, hm);
    }
    private List<String> breakWord(String s, Set<String> dict, Map<String, List<String>> hm){
        if(hm.containsKey(s)){
            return hm.get(s);
        }
        List<String> res = new ArrayList<>();
        if(dict.contains(s)){
            res.add(s);
        }/* if the whole word is in the dict, then look at the sub-word in this word to find all possible result, so not use else */
        for(int i = 1; i < s.length(); i++){    /* DFS starts from the end of the word */
            String word = s.substring(0, i);
            if(dict.contains(word)){
                String remain = s.substring(i);
                List<String> sublist = breakWord(remain, dict, hm);
                if(sublist.size() != 0){
                    for(String sub : sublist){
                        res.add(word + " " + sub);
                    }
                }
            }
        }
        hm.put(s, res);
        return res;
    }
}
