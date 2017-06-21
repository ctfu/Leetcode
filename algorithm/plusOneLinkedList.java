/* Method 1: reverse LinkedList */
public class Solution {
    public ListNode plusOne(ListNode head) {
        if(head == null) return new ListNode(1);
        ListNode newHead = reverse(head);
        ListNode cur = newHead;
        ListNode tail = null;
        while(cur != null){
            if(cur.val < 9){
                cur.val = cur.val + 1;
                return reverse(newHead);
            }
            cur.val = 0;
            tail = cur;
            cur = cur.next;
        }
        tail.next = new ListNode(1);
        return reverse(newHead);
    }
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
