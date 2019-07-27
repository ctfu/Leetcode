/*
A group of two or more people wants to meet and minimize the total travel
distance. You are given a 2D grid of values 0 or 1, where each 1 marks the home
of someone in the group. The distance is calculated using Manhattan Distance,
where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.
*/
/* Seperate 1 two dimention into two 1-D array
 * Each position is seperated into its row index and col index
 * Median provides the shortes distance */
public class Solution {
    public int minTotalDistance(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        List<Integer> x = new ArrayList<>();    /* x cordinate */
        List<Integer> y = new ArrayList<>();    /* y cordinate */
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1){
                    x.add(i);
                    y.add(j);
                }
            }
        }
        return getMin(x) + getMin(y);
    }
    private int getMin(List<Integer> list){
        if(list == null || list.size() == 0){
            return 0;
        }
        Collections.sort(list); /* sort the cordinate and get the sum of shortes distance */
        int begin = 0, end = list.size()-1;
        int res = 0;
        while(begin < end){
            res += list.get(end)-list.get(begin);
            begin++;
            end--;
        }
        return res;
    }
}
