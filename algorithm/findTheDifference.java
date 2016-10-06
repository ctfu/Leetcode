public class Solution {
    public char findTheDifference(String s, String t) {
        char result = t.charAt(t.length() - 1);
        for(int i = 0; i < t.length() -1; i++){
            //need to use ^= instead of result = result ^ t.charAt(i)
            result ^= t.charAt(i);
            result ^= s.charAt(i);
        }

        return result;
    }
}
