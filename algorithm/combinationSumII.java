public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(candidates); /* sort if numbers have duplicate */
        combination(res, candidates, target, new ArrayList<Integer>(), 0);
        return res;
    }
    private void combination(List<List<Integer>> res, int[] candidates,
                                int target, List<Integer> tempList, int index){
        if(target < 0 || target != 0 && index == candidates.length){
            return;
        }
        if(target == 0){
            res.add(new ArrayList<Integer>(tempList));
        }else{
            for(int i = index; i < candidates.length; i++){
                tempList.add(candidates[i]);
                combination(res, candidates, target-candidates[i], tempList, i + 1);
                tempList.remove(tempList.size()-1);
                /* get rid of duplicates */
                while(i < candidates.length -1 && candidates[i] == candidates[i+1]) i++;
            }
        }
    }
}
