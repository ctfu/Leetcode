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
         if (head == null) {
             return null;
         }
         /* don't need dummy node here because head is odd, which will be kept */
         ListNode prev = head;
         ListNode first = prev.next;
         while (first != null && first.next != null) {
             ListNode second = first.next;
             first.next = second.next;
             second.next = prev.next;
             prev.next = second;
             first = first.next;
             prev = prev.next;
         }
         return head;
     }
 }
