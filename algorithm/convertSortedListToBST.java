/* Recursive to buildTree according the middle ListNode o(nlogn)*/
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head, null);
    }
    private TreeNode buildTree(ListNode head, ListNode tail){
        if(head == tail) return null;
        ListNode fast = head, slow = head;
        /* get the middle ListNode, here null changed to tail */
        while(fast != tail && fast.next != tail){
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = buildTree(head, slow);
        root.right = buildTree(slow.next, tail);
        return root;
    }
}
