/* sort a linkedList o(nlogn) time */
/* merge sort approach by finding middle node */
public class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode fast = head, slow = head, tail = null;
        /* when out of this while loop, slow will be the middle, and always biased to the right */
        while(fast != null && fast.next != null){
            tail = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        tail.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(slow);
        return merge(left, right);
    }
    private ListNode merge(ListNode l1, ListNode l2){
        if(l1 == null && l2 == null) return null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = merge(l1.next, l2);
            return l1;
        }else{
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }
}
