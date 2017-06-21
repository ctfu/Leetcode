/* use stack to implement, not valid directory name are (".", "") */
/* pop the stack whenever see ".." */

public class Solution {
    public String simplifyPath(String path) {
        StringBuilder res = new StringBuilder();
        Stack<String> stack = new Stack<>();
        for(String dir : path.split("/")){
            if(dir.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else if(dir.equals(".") || dir.equals("")){
                continue;
            }else{
                stack.push(dir);
            }
        }
        for(String s : stack){  /* iterate stack in bottom up order */
            res.append("/");
            res.append(s);
        }

        return res.length() == 0 ? "/" : res.toString();
    }
}
