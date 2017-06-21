/* 1)use recursion in combinations,
   2)provide index to loop through the candidates
   3)pick or not pick the number, if picked (target - picked value) */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        combination(res, candidates, target, new ArrayList<Integer>(), 0);
        return res;
    }
    private void combination(List<List<Integer>> res, int[] candidates, int target, List<Integer> tempList, int index){
        if(target < 0 || (target != 0 && index == candidates.length)){
            return;
        }
        if(target == 0){
            res.add(new ArrayList<Integer>(tempList));
        }else{
            for(int i = index; i < candidates.length; i++){
                tempList.add(candidates[i]);
                combination(res, candidates, target-candidates[i], tempList, i);/* same number can be picked multiple times */
                tempList.remove(tempList.size()-1);
            }
        }
    }
}
