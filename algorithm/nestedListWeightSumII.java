/* Requirement: Now weight is increasing from leaf to root, leaf has weight 1, root has the max weight */
public class Solution {
    private int depth = 0;
    public int depthSumInverse(List<NestedInteger> nestedList) {
        getDepth(nestedList, 1);
        return getSum(nestedList, depth);
    }
    private void getDepth(List<NestedInteger> list, int level){
        depth = Math.max(depth, level);
        for(int i = 0; i < list.size(); i++){
            if(!list.get(i).isInteger()){
                List<NestedInteger> newList = list.get(i).getList();
                getDepth(newList, level+1);
            }
        }
    }
    private int getSum(List<NestedInteger> list, int level){
        int sum = 0;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).isInteger()){
                sum += list.get(i).getInteger() * level;
            }else{
                List<NestedInteger> newList = list.get(i).getList();
                sum += getSum(newList, level-1);
            }
        }
        return sum;
    }
}

/* A better approach, without using depth and multiplication. adding the number multiple times */
public class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int weighted = 0, unweighted = 0;
        while(!nestedList.isEmpty()){
            List<NestedInteger> nextLevel = new ArrayList<>();
            for(NestedInteger ni : nestedList){
                if(ni.isInteger()){
                    unweighted += ni.getInteger();
                }else{
                    nextLevel.addAll(ni.getList());
                }
            }
            weighted += unweighted;
            nestedList = nextLevel;
        }
        return weighted;
    }
}
