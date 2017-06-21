/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
/*
    1                                  1 ->null
   /  \                               / \
  2    3            -->              2-> 3 -> null
 / \  / \                           / \ / \
4  5  6  7                         4->5->6->7 -> null */
/* Assume perfect binary tree */
/* Level order traversal from right to left, and consider each level as LinkedList */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            TreeLinkNode head = null;  /* set a level LinkedList head */
            for(int i = 0; i < size; i++){
                TreeLinkNode top = queue.poll();
                if(top.right != null) queue.offer(top.right); /* add the TreeLinkNode in reverse order */
                if(top.left != null) queue.offer(top.left);
                top.next = head;
                head = top;
            }
        }
    }
}

/* Method 2: question Requirement is constant space, use two pointers */
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode pre = root;
        TreeLinkNode cur = null;
        while(pre != null){
            cur = pre; /* assign a new reference to keep the pre position */
            while(cur != null){
                if(cur.left != null){
                    cur.left.next = cur.right;
                    if(cur.next != null){
                        cur.right.next = cur.next.left;
                    }
                }
                cur = cur.next;
            }
            /* it is perfect binary tree, the next level head node is always pre.left
             * if regular binary tree, this changes */
            pre = pre.left;
        }
    }
}
