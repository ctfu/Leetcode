/* Author: ctfu   */
/* Title: Odd Even LinkedList */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        /* separate the list into odd and even list by chaning the pointers */
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;       /* maintain the head of the even list for last connectivity */
        while(even != null && even.next != null){
            odd.next = even.next;
            even.next = odd.next.next;  /* even can be null because of this */
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
