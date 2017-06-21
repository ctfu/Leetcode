/* Given two interger n, k, find all combination of k numbers from [1,n] */
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        combine(res, n, k, new ArrayList<Integer>());
        return res;
    }
    public void combine(List<List<Integer>> res, int n, int k, List<Integer> tempList){
        if(k < 0 || k != 0 && n < 1){
            return;
        }
        if(k == 0){
            res.add(new ArrayList<Integer>(tempList));
        }else{
            tempList.add(n);
            combine(res, n-1, k-1, tempList);
            tempList.remove(tempList.size()-1);
            combine(res, n-1, k, tempList);
        }
    }
}
