/* Return concatenated words that are concatenated with two or more shorter words in the given lists */
/* Approach: make use of work break
 * 1. sort the words accending order by str length
 * 2. construct a new dictionary
 * 3. check word break status for each str */
public class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        if(words == null || words.length == 0) return res;

        Set<String> dict = new HashSet<>();
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        for(int i = 0; i < words.length; i++){
            if(canBreak(words[i], dict) && words[i].length() != 0){ /* no empty string "" */
                res.add(words[i]);
            }
            dict.add(words[i]);
        }
        return res;
    }

    private boolean canBreak(String s, Set<String> dict){
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && dict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
