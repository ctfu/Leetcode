/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        //two nodes in a roll, recursive down
        ListNode newNode = swapPairs(head.next.next);
        ListNode newHead = head.next;
        head.next = newNode;
        newHead.next = head;

        return newHead;
    }
}
//without recursive, use dummy head node
public ListNode swapPairs(ListNode head) {
    ListNode dummy = new ListNode();
    dummy.next = head;
    ListNode current = dummy;
    while (current.next != null && current.next.next != null) {
        ListNode first = current.next;
        ListNode second = current.next.next;
        first.next = second.next;
        current.next = second;
        current.next.next = first;
        current = current.next.next;
    }
    return dummy.next;
}
