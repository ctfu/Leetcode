public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<List<String>>();
        Set<String> dict = new HashSet<>(wordList);
        if(!dict.contains(endWord)) return res;

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        /* hashMap to record the path in reverse order */
        Map<String, List<String>> hm = new HashMap<>();
        boolean isFinished = false;
        while(!queue.isEmpty()){
            /* it needs to use hashset here to reduce duplicate */
            Set<String> queue2 = new HashSet<>();
            while(!queue.isEmpty()){
                String top = queue.poll();
                List<String> oneDistanceWords = getOneDistanceWords(dict, top);
                for(String word : oneDistanceWords){
                    if(word.equals(endWord)){
                        isFinished = true;
                    }
                    if(!visited.contains(word)){
                        storePath(hm, top, word);
                        queue2.add(word);
                        /* doesnot set visited here, may loose some path */
                    }
                }
            }
            visited.addAll(queue2);
            if(isFinished){
                getPath(res, hm, new ArrayList<String>(), endWord);
                break;
            }
            queue.addAll(queue2);
        }
        return res;
    }
    private List<String> getOneDistanceWords(Set<String> dict, String word){
        List<String> res = new ArrayList<>();
        char[] wordArray = word.toCharArray();
        for(int i = 0; i < wordArray.length; i++){
            char oriChar = wordArray[i];
            for(char c = 'a'; c <= 'z'; c++){
                if(c == oriChar) continue;
                wordArray[i] = c;
                String newWord = new String(wordArray);
                if(dict.contains(newWord)){
                    res.add(newWord);
                }
            }
            wordArray[i] = oriChar;
        }
        return res;
    }
    private void storePath(Map<String, List<String>> hm, String pre, String cur){
        if(!hm.containsKey(cur)){
            hm.put(cur, new ArrayList<String>());
        }
        hm.get(cur).add(pre);
    }
    private void getPath(List<List<String>> res, Map<String, List<String>> hm, List<String> tempList, String endWord){
        /* reaches beginWord*/
        if(!hm.containsKey(endWord)){
            tempList.add(endWord); /* add the begin work */
            Collections.reverse(tempList);
            res.add(tempList);
        }else{
            for(String pre : hm.get(endWord)){
                List<String> newTemp = new ArrayList<>(tempList);/* important to use a new list here */
                newTemp.add(endWord);
                getPath(res, hm, newTemp, pre);
            }
        }
    }
}
