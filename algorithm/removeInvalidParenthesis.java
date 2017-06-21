/* BFS level order
 * first lavel: remove nothing
 * second level: remove one char parthesis
 * ... */
public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if(s == null) return res;
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(s);
        visited.add(s); /* use set to prevent duplicate, such as "(()", remove index 0, or 1,  result is "()" */
        boolean found = false;
        while(!queue.isEmpty()){
            String top = queue.poll();
            if(isValid(top)){
                res.add(top);
                found = true;
            }
            if(found) continue;

            for(int i = 0; i < top.length(); i++){
                if(top.charAt(i) != '(' && top.charAt(i) != ')') continue;
                String newStr = top.substring(0, i) + top.substring(i+1);
                if(!visited.contains(newStr)){
                    visited.add(newStr);
                    queue.offer(newStr);
                }
            }
        }
        return res;
    }
    private boolean isValid(String s){
        int parentCount = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                parentCount++;
            }
            if(s.charAt(i) == ')'){
                parentCount--;
                if(parentCount < 0){
                    return false;
                }
            }
        }
        return parentCount == 0;
    }
}
