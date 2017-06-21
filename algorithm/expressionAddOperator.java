/* Approach: backtracking */
public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if(num == null || num.length() == 0) return res;
        addOperator(res, num, target, "", 0, 0, 0);
        return res;
    }
    /* A nice trick here variable forMul is used for the future next multiplication */
    private void addOperator(List<String> res, String num, int target, String path, long eval, long forMul, int index){
        if(index == num.length()){
            if(eval == target){
                res.add(path);
            }
        }else{
            for(int i = index; i < num.length(); i++){
                if(i != index && num.charAt(index) == '0') break;   /* prevent number with leading zero */
                long cur = Long.parseLong(num.substring(index, i+1));
                if(index == 0){
                    addOperator(res, num, target, path+cur, cur, cur, i+1);
                }else{
                    addOperator(res, num, target, path+"+"+cur, eval+cur, cur, i+1);
                    addOperator(res, num, target, path+"-"+cur, eval-cur, -cur, i+1);
                    /* eval-forMul: subtract forMul if previous "-" operation or adds forMul if previous "-" operation */
                    addOperator(res, num, target, path+"*"+cur, eval-forMul+forMul*cur, forMul*cur, i+1);
                }
            }
        }
    }
}
