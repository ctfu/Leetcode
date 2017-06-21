/* Author: ctfu       */
/* Title: Intersection of Two Linked Lists */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){   /* based case */
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        while(a != b){
            a = a == null?headB:a.next;
            b = b == null?headA:b.next;
        }
        return a;   /* if no intersection, a and b will simply be null */
    }
}
