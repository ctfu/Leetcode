/* union find to detect cycle */
/* three cases of this problem
1. if a node has two parents
2. if not 1, but the graph has cycle
3. if a node has two parents and exists cycle */
class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] can1 = {-1, -1};
        int[] can2 = {-1, -1};
        int[] root = new int[edges.length + 1];
        for (int[] edge : edges) {
            if (root[edge[1]] == 0) {
                root[edge[1]] = edge[0];
            } else {
                can2 = new int[] {edge[0], edge[1]};
                can1 = new int[] {root[edge[1]], edge[1]};
                edge[1] = 0;
            }
        }
        for (int i = 0; i < root.length; i++) {
            root[i] = i;
        }
        for (int[] edge : edges) {
            if (edge[1] == 0) {
                continue;
            }
            if (find(root, edge[0]) == edge[1]) {
                if (can1[0] == -1) {
                    return edge;
                } else {
                    return can1;
                }
            }
            root[edge[1]] = edge[0];
        }
        return can2;
    }

    public int find(int[] root, int p) {
        while (p != root[p]) {
            root[p] = root[root[p]];
            p = root[p];
        }
        return p;
    }
}
