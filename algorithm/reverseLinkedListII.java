/*Simply just reverse the list along the way using 4 pointers: dummy, pre, first, second*/
/* The problem assums m, n position is valid */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        for(int i = 0; i < m-1; i++){
            pre = pre.next; //move before m position，because added dummy
        }
        ListNode first = pre.next;
        for(int i = 0; i < n-m; i++){
            ListNode second = first.next;
            first.next = second.next;
            second.next = pre.next;
            pre.next = second;
        }
        return dummy.next;
    }
}
