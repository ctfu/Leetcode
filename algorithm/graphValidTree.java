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

/* Approach 2: DFS, but need to build adjacency list
* time complexity: O(n), space complexity: O(n)
*/
public class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<List<Integer>>(n);
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        if (hasCycle(adjList, visited, 0, -1)) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }
    /* a method to detect cycle in undirected graph */
    public boolean hasCycle(List<List<Integer>> adjList, boolean[] visited, int u, int parent) {
        visited[u] = true;
        for (int v : adjList.get(u)) {
            // if visited, need to check if single node 
            if (visited[v] && v != parent || !visited[v] && hasCycle(adjList, visited, v, u)) {
                return true;
            }
        }
        return false;
    }
}
