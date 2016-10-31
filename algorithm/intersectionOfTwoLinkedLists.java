/* Author: ctfu       */
/* Title: Intersection of Two Linked Lists */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
/* The method places focus on lists length, insteading of comparing list values. The program complexity is O(n+m).*/
/* If n > m, for the first n elements is to conteract the list position, the second m elements finds the answer.  */

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){   /* based case */
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        while(a != b){
            //if(a != null || b != null) add this condition to prevent there is no intersection with some or differnet length
            a = a == null?headB:a.next;
            b = b == null?headA:b.next;
        }
        return a;   /* if no intersection, a and b will simply be null */
    }
}
