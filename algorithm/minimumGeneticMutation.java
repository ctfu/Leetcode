/* Approach: BFS (similar problem as wordLaddar)
 * The difference is that wordLaddar change one char form a-z,
 * gen mutation change one char from specific vocabulary
 * Time complexity: O(MN), M is number of gens mutatable in genBank, N is each gen length */
public class Solution {
    public int minMutation(String start, String end, String[] bank) {
        if(bank == null || bank.length == 0) return -1;
        Set<String> genBank = new HashSet<>();
        for(int i = 0; i < bank.length; i++){
            genBank.add(bank[i]);
        }
        if(!genBank.contains(end)) return -1;

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);
        int mutation = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String gen = queue.poll();
                List<String> gens = getOneCharacterMutation(genBank, gen);
                for(String g : gens){
                    if(g.equals(end)){
                        return mutation + 1;
                    }
                    if(!visited.contains(g)){
                        queue.offer(g);
                        visited.add(g);
                    }
                }
            }
            mutation++;
        }
        return -1;
    }
    private List<String> getOneCharacterMutation(Set<String> bank, String gen){
        List<String> gens = new ArrayList<>();
        char[] choice = {'A', 'C', 'G', 'T'};   /* only mutation from these choice */
        char[] genArr = gen.toCharArray();
        for(int i = 0; i < genArr.length; i++){
            char origChar = genArr[i];
            for(int j = 0; j < choice.length; j++){
                if(genArr[i] == choice[j]) continue;
                genArr[i] = choice[j];
                String newGen = new String(genArr);
                if(bank.contains(newGen)){
                    gens.add(newGen);
                }
            }
            genArr[i] = origChar;
        }
        return gens;
    }
}
