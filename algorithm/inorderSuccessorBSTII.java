/*
Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

The successor of a node p is the node with the smallest key greater than p.val.

You will have direct access to the node but not to the root of the tree.
Each node will have a reference to its parent node.

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/
class Solution {
    public Node inorderSuccessor(Node x) {
        if(x == null) return null;
        if (x.right != null) {
            x = x.right;
            while(x.left != null) x = x.left;
            return x;
        } else {
            while(x.parent != null && x.parent.left != x) {
                x = x.parent;
            }
            return x.parent;
        }
    }
}
