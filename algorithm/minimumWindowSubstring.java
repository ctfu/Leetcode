public String minWindow(String s, String t) {
    int[] cache = new int[256];
    int begin = 0, end = 0;
    int minStart = 0, minLen = Integer.MAX_VALUE;
    int counter = t.length();

    for(char c : t.toCharArray()){
        cache[c]++;       /* count the occurrence of character in target */
    }
    while(end < s.length()){
        char c = s.charAt(end);
        if(cache[c] > 0){
            counter--;
        }
        cache[c]--;
        end++;
        while(counter == 0){    /* found a valid string */
            if(end - begin < minLen){
                minStart = begin;
                minLen = end - begin;
            }
            char c1 = s.charAt(begin);
            if(cache[c1] == 0){
                counter++;
            }
            cache[c1]++;
            begin++;
        }
    }
    return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
}
