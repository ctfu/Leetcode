/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    //use slow and fast pointer to maintain n nodes between, so that when fast reaches
    //to the end, slow is the position right before target node
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        ListNode dummy = new ListNode(-1);/* since head could be removed, use dummy */
        dummy.next = head;
        ListNode pre = dummy;
        while(n-- != 0){ /* matintain a n gap, since added dummy, position will be just before the nth node */
            pre = pre.next;
        }
        ListNode slow = dummy;  /* make sure here we starts with dummy */
        while(pre.next != null){
            pre = pre.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
