/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
 /* because it is an undirected graph, we need to hash map to prevent circle */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Map<Integer, UndirectedGraphNode> hm = new HashMap<>();/* hashMap to store the visited node */
        return dfs(node, hm);
    }
    private UndirectedGraphNode dfs(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> hm){
        if(node == null) return null;
        if(hm.containsKey(node.label)){
            return hm.get(node.label);
        }
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        /* visite the current node, important here to add the copy node rather than node, because we need to reture it */
        hm.put(node.label, copy);
        for(UndirectedGraphNode gNode : node.neighbors){
            copy.neighbors.add(dfs(gNode, hm));
        }
        return copy;
    }
}
