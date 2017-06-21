/* Approach: move end pointer, each time reach to a anagram window, move left pointer
 * 1. The question is similar to Minimum Window Substring,
 * Difference: can have interveting character in between, need to find the smallest window.
 * 2. The idea can be apply to SubstringWithConcantenationAllWords
 * Difference: cannot use hashtable, words are string not character, use hashmap to
 * check when a valid word appear and two hashmap comparison to adjust counter */
public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if(p == null || p.length() == 0 || s == null || s.length() == 0){
            return list;
        }
        int[] hash = new int[256];
        for(char c: p.toCharArray()){
            hash[c]++;
        }

        int left = 0, right = 0, count = p.length();
        while(right < s.length()){
            if(hash[s.charAt(right++)]-- >= 1) count--;
            if(count == 0) list.add(left);
            /* important: maintain a p.length window, check if not valid answer, move left */
            if(right - left == p.length() && hash[s.charAt(left++)]++ >= 0) count++;
        }
        return list;
    }
}
