/* Follow up change: Assume any binary tree */
/* Level order traversal */
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode cur = root;    /* the current root */
        TreeLinkNode head = null;   /* the head node on each level */
        TreeLinkNode leading = null;    /* the leading node on each level */
        while(cur != null){
            /* deal with each level, cur = cur.next */
            while(cur != null){
                if(cur.left != null){   /* left child */
                    if(leading != null){    /* not the first left child */
                        leading.next = cur.left;
                        leading = leading.next;
                    }else{
                        head = cur.left;
                        leading = head;
                    }
                }
                if(cur.right != null){  /* right child */
                    if(leading != null){
                        leading.next = cur.right;
                        leading = leading.next;
                    }else{
                        head = cur.right;
                        leading = head;
                    }
                }
                cur = cur.next; /* move right */
            }
            cur = head;
            head = null;
            leading = null;
        }
    }
}
