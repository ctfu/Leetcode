/* Approach: divide and conqure.
 * Divide the input stirng into two parts and recursively solved each part */
public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        if(input == null || input.length() == 0){
            return res;
        }

        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == '+' ||
                input.charAt(i) == '-' ||
                input.charAt(i) == '*'){
                String part1 = input.substring(0, i);
                String part2 = input.substring(i+1);
                List<Integer> part1Result = diffWaysToCompute(part1);
                List<Integer> part2Result = diffWaysToCompute(part2);
                for(Integer r1 : part1Result){
                    for(Integer r2 : part2Result){
                        char ch = input.charAt(i);
                        int combine = 0;
                        switch(ch){
                            case '+':
                                combine = r1 + r2;
                                break;
                            case '-':
                                combine = r1 - r2;
                                break;
                            case '*':
                                combine = r1 * r2;
                                break;
                        }
                        res.add(combine);
                    }
                }
            }
        }
        if(res.size() == 0){    /* when the part contains only number and no operator (won't go into if condition) */
            res.add(Integer.parseInt(input));
        }
        return res;
    }
}
