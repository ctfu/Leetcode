public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        genParenthesis(res, n, n, "");
        return res;
    }
    public void genParenthesis(List<String> res, int left, int right, String prefix){
        if(left == 0 && right == 0){
            res.add(prefix);
        }else{
            if(left > 0){
                genParenthesis(res, left-1, right, prefix+"(");
            }
            if(right > left){ /* this condition is important */
                genParenthesis(res, left, right-1, prefix+")");
            }
        }
    }
}

/* replace prefix with StringBuilder */
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        genParenthesis(res, n, n, sb);
        return res;
    }
    public void genParenthesis(List<String> res, int left, int right, StringBuilder sb){
        if(left == 0 && right == 0){
            res.add(sb.toString());
        }else{
            if(left > 0){
                sb.append("(");
                genParenthesis(res, left-1, right, sb);
                sb.setLength(sb.length()-1);
            }
            if(right > left){
                sb.append(")");
                genParenthesis(res, left, right-1, sb);
                sb.setLength(sb.length()-1);
            }
        }
    }
}
