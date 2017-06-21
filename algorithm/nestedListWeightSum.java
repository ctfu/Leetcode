/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return getSum(nestedList, 1);
    }
    private int getSum(List<NestedInteger> list, int depth){
        int sum = 0;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).isInteger()){
                sum += list.get(i).getInteger() * depth;
            }else{
                List<NestedInteger> newList = list.get(i).getList();
                sum += getSum(newList, depth+1);
            }
        }
        return sum;
    }
}
