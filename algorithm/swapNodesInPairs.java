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
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        while(pre.next != null && pre.next.next != null){
            ListNode first = pre.next;
            ListNode second = pre.next.next;
            first.next = second.next;
            second.next = pre.next;
            pre.next = second;
            pre = first;
        }
        return dummy.next;
    }
}
