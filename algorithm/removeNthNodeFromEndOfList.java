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
       ListNode start = new ListNode(0); //the reason to define a start, becasue the head could be the removed node
       ListNode slow = start, fast = start;
       slow.next = head;
       for(int i = 0; i < n + 1; i++){
           fast = fast.next;
       }
       while(fast != null){
           fast = fast.next;
           slow = slow.next;
       }
       slow.next = slow.next.next;
       return start.next;
    }
}
