public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        /* use k to count numbers picked, passed 1 as starting number */
        combo(res, n, k, 1, new ArrayList<Integer>());
        return res;
    }
    private void combo(List<List<Integer>> res, int n, int k, int start,
                                        List<Integer> tempList){
        if(n < 0 || n != 0 &&start > 9 || n== 0 && k != 0) return;
        if(n == 0 && k==0){
            res.add(new ArrayList<Integer>(tempList));
        }else{
            /* no matter pick or not pick, increment souce number start */
            combo(res, n, k, start+1, tempList);
            tempList.add(start);
            /* remember to substract from target and reduce k if pick the number */
            combo(res, n-start, k-1, start+1, tempList);
            tempList.remove(tempList.size() - 1);
        }
    }
}
