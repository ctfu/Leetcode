/*
Given a binary tree where all the right nodes are either leaf nodes with a
sibling (a left node that shares the same parent node) or empty, flip it
upside down and turn it into a tree where the original right nodes turned
into left leaf nodes. Return the new root.

Example:

Input: [1,2,3,4,5]

    1
   / \
  2   3
 / \
4   5

Output: return the root of the binary tree [4,5,2,#,#,3,1]

   4
  / \
 5   2
    / \
   3   1
Clarification:

Confused what [4,5,2,#,#,3,1] means? Read more below on how binary tree is serialized on OJ.

The serialization of a binary tree follows a level order traversal, where '#'
signifies a path terminator where no node exists below.

Here's an example:

   1
  / \
 2   3
    /
   4
    \
     5
The above binary tree is serialized as [1,2,3,#,#,4,#,#,5].
*/
/* From question, we know that:
 * 1. if there is a right node, there must be a left node, so we only need to check left node
 * 2. flip the tree, by changing the each left node's left and right substree nodes
 * time complexity: O(logn), only recursive the left subtree, space complexity: O(logn)
 */
public class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null) {
            return root;
        }
        TreeNode newNode = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return newNode;
    }
}
