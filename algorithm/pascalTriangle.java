public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTri = new ArrayList<List<Integer>>();
        if(numRows == 0) return pascalTri;

        List<Integer> list0 = new ArrayList<>();
        list0.add(1);
        pascalTri.add(list0);

        for(int i = 1; i < numRows; i++){
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for(int j = 0; j < pascalTri.get(i - 1).size() - 1; j++){
                list.add(pascalTri.get(i-1).get(j) + pascalTri.get(i-1).get(j+1));
            }
            list.add(1);
            pascalTri.add(list);
        }
        return pascalTri;
    }
}
