/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 public class Solution {
     public ListNode removeElements(ListNode head, int val) {
         ListNode dummy = new ListNode(-1);
         dummy.next = head;
         ListNode pre = dummy;
         while(pre.next != null){
             if(pre.next.val == val){
                 pre.next = pre.next.next;
             }else{
                 pre = pre.next;
             }
         }
         return dummy.next;
     }
 }
