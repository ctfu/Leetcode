/* maxHeap (sort entry by frequency) + HashMap(count char frequency) */
public class Solution {
    public String frequencySort(String s) {
        if(s == null || s.length() == 0) return s;
        Map<Character, Integer> hm = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            hm.put(c, hm.getOrDefault(c, 0)+1);
        }
        /*
        PriorityQueue<Map.Entry<Character, Integer>> heap = new PriorityQueue<>(hm.size(),
            new Comparator<Map.Entry<Character, Integer>>(){
               @Override
               public int compare(Map.Entry<Character, Integer> entry1, Map.Entry<Character, Integer> entry2){
                   return entry2.getValue() - entry1.getValue();
               }
           });    */
        PriorityQueue<Map.Entry<Character, Integer>> heap = new PriorityQueue<>(hm.size(),
                                                (a, b) -> b.getValue() - a.getValue());
        for(Map.Entry<Character, Integer> entry : hm.entrySet()){
            heap.offer(entry);
        }
        while(!heap.isEmpty()){
            Map.Entry<Character, Integer> entry = heap.poll();
            int freq = entry.getValue();
            while(freq != 0){
                sb.append(entry.getKey());
                freq--;
            }
        }
        return sb.toString();
    }
}
