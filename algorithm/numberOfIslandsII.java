/* Union-Find:
* how to determin edge relationship in 2D grid?
* 1. Fill each cell ground id as -1 initially
* 2. Search around the position, if any surround cell's group id is not -1, means there is an edge, we then union then
*/
public class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        if (m <= 0 || n <= 0) {
            return res;
        }
        int[] id = new int[m * n];
        Arrays.fill(id, -1);
        int count = 0;
        for (int[] pos : positions) {
            int mark = pos[0] * n + pos[1]; // 2D -> 1D
            id[mark] = mark;
            count++;
            // search around the postion cell, a possible edge is found if near cell's group id is not -1
            int[] direct = {0, 1, 0, -1, 0};
            for (int k = 0; k < 4; k++) {
                int x = pos[0] + direct[k];
                int y = pos[1] + direct[k + 1];
                int nPos = x * n + y;
                if (x < 0 || x >= m || y < 0 || y >= n || id[nPos] == -1) {
                    continue;
                }
                int nPosId = find(id, nPos);
                if (nPosId != mark) {
                    id[nPosId] = mark;
                    count--;
                }
            }
            res.add(count);
        }
        return res;
    }
    public int find(int[] id, int p) {
        while (id[p] != p) {
            id[p] = id[id[p]];
            p = id[p];
        }
        return p;
    }
}
