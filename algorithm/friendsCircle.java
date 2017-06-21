/* Method1: Union Find (Quick-union), time complexity: O(logn * n^2)*/
public class Solution {
    public int findCircleNum(int[][] M) {
        int[] friends = new int[M.length];
        for(int i = 0; i < friends.length; i++){
            friends[i] = i;
        }
        int circle = friends.length;
        for(int i = 0; i < M.length; i++){
            for(int j = i + 1; j < M[i].length; j++){
                if(M[i][j] == 1){
                    int root1 = find(friends, i);
                    int root2 = find(friends, j);
                    if(root1 == root2) continue;
                    friends[root1] = root2;
                    circle--;
                }
            }
        }
        return circle;
    }
    /* log(n) for find */
    private int find(int[] friends, int p){
        while(p != friends[p]){
            friends[p] = friends[friends[p]];   /* path compression */
            p = friends[p];
        }
        return p;
    }
}

/* DFS, time complexity: O(n^3)*/
public class Solution {
    public int findCircleNum(int[][] M) {
        int circle = 0;
        boolean[] visited = new boolean[M.length];
        for(int i = 0; i < M.length; i++){
            if(!visited[i]){
                visited[i] = true;
                circle++;
                findCircle(M, visited, i);
            }
        }
        return circle;
    }
    private void findCircle(int[][] friends, boolean[] visited, int i){
        for(int j = 0; j < friends[i].length; j++){
            if(j != i && !visited[j] && friends[i][j] == 1){
                visited[j] = true;
                findCircle(friends, visited, j);
            }
        }
    }
}
