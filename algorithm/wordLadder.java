/* 1. keep a set of all words can be transform to
 * 2. for each word in transform words, get all the words within one distance from dict
 * 3. if end word is added, return; else add the one words geted to the transform word set */
public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        /* hashset searching takes o(1) time */
        Set<String> dict = new HashSet<>(wordList);
        if(!dict.contains(endWord)) return 0;/* if end word is not in the wordList, return 0 */

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        /* the reason to use a set here: becase searching in set take o(1) time */
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int distance = 1;
        while(!queue.isEmpty()){
            Queue<String> queue2 = new LinkedList<>();
            distance++;
            while(!queue.isEmpty()){
                String top = queue.poll();
                List<String> oneDistanceWords = getOneDistanceWords(dict, top);
                for(String word : oneDistanceWords){
                    if(word.equals(endWord)){
                        return distance;
                    }
                    if(!visited.contains(word)){
                        queue2.offer(word);
                        visited.add(word);
                    }
                }
            }
            queue = queue2;
        }
        return 0;
    }
    private List<String> getOneDistanceWords(Set<String> wordList, String word){
        List<String> res = new ArrayList<>();
        char[] charWords = word.toCharArray();
        for(int i = 0; i < charWords.length; i++){
            char oriChar = charWords[i];
            for(char c = 'a'; c <= 'z'; c++){
                if(c == oriChar) continue;
                charWords[i] = c;
                String newWord = new String(charWords);
                /* here do a lot of searching, that's why conversted to a hashset */
                if(wordList.contains(newWord)){
                    res.add(newWord);
                }
            }
            charWords[i] = oriChar;
        }
        return res;
    }
}

/* two-way BFS from both end */
public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if(!dict.contains(endWord)) return 0;

        Set<String> beginSet = new HashSet<>(), endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        visited.add(endWord);
        int distance = 1;
        while(!beginSet.isEmpty() && !endSet.isEmpty()){
            /* always search from the smaller set */
            if(beginSet.size() > endSet.size()){
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            Set<String> temp = new HashSet<>();
            for(String word : beginSet){
                char[] wordArray = word.toCharArray();
                for(int i = 0; i < wordArray.length; i++){
                    char oriChar = wordArray[i];
                    for(char c = 'a'; c <= 'z'; c++){
                        wordArray[i] = c;
                        String newWord = new String(wordArray);
                        if(endSet.contains(newWord)){
                            return distance + 1;
                        }
                        if(!visited.contains(newWord) && dict.contains(newWord)){
                            temp.add(newWord);
                            visited.add(newWord);
                        }
                    }
                    wordArray[i] = oriChar;
                }
            }
            beginSet = temp;
            distance++;
        }
        return 0;
    }
}
