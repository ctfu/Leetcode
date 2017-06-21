/* Union-Find, O(nh), h is the tree height */
public class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] roots = new int[n];   /* initialize the Union-Find */
        for(int i = 0; i < n; i++){
            roots[i] = i;
        }
        for(int[] e : edges){
            /* union function */
            int root1 = find(roots, e[0]);
            int root2 = find(roots, e[1]);
            if(root1 != root2){
                roots[root1] = root2;
                n--;    /* only reduce count if actually unions */
            }
        }
        return n;
    }
    /* O(h) for find */
    private int find(int[] roots, int id){
        while(roots[id] != id){
            roots[id] = roots[roots[id]]; /* path compression */
            id = roots[id];
        }
        return id;
    }
}
