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
            if(right - left == p.length() && hash[s.charAt(left++)]++ >= 0) count++;
        }
        return list;
    }
}
