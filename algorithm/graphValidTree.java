/* Approach 1: Union Find, to see if all the edges are connected in a single group
* time complexity: O(n), space complexity: O(n)
*/
public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (n == 0) {
            return true;
        }
        int[] id = new int[n];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
        int count = n;
        for (int[] edge : edges) {
            int p = find(id, edge[0]);
            int q = find(id, edge[1]);
            if (p == q) {
                return false;   // a valid tree indicates two children rooted on a same tree can connect 
            }
            id[p] = q;
            count--;
        }
        return count == 1;
    }
    public int find(int[] id, int p) {
        while (p != id[p]) {
            id[p] = id[id[p]];  // with tree compression, find() operates almsot O(1)
            p = id[p];
        }
        return p;
    }
}
