import java.util.*;
public class KnapSack{
    public static void main(String[] args){
        int[] nums = {2, 3, 6, 7};
        ArrayList<ArrayList<Integer>> res = knapsack(nums, 7);
        System.out.println("ressult is: " + res);
    }
    public static ArrayList<ArrayList<Integer>> knapsack(int[] candidates,
                                                         int target) {
        Arrays.sort(candidates);
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> cur = new ArrayList<Integer>();
        knapsack(candidates, 0, target, results, cur);
        return results;
    }

    public static void knapsack(int[] candidates, int index, int target,
                                ArrayList<ArrayList<Integer>> results,
                                ArrayList<Integer> cur) {
        if (target < 0 || (target != 0 && index == candidates.length)) {
            return;
        }
        if (target == 0) {
            results.add(new ArrayList<Integer>(cur));
            return;
        }
        cur.add(candidates[index]);
        System.out.println(cur);
        knapsack(candidates, index, target-candidates[index], results, cur);
        cur.remove(cur.size()-1);
        System.out.println(cur);
        knapsack(candidates, index+1, target, results, cur);
    }
}
