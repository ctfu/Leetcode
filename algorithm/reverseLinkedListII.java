/*
Reverse a linked list from position m to n. Do it in one-pass.

Note: 1 ≤ m ≤ n ≤ length of list.

Example:

Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL
*/
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
