/* 1. the problem is essentially a multiple subproblem of reverse between k
 * 2. the begin index of pre is dummy */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) { /* k needs to be greater than 0 */
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        int length = 0;
        while(cur != null){
            cur = cur.next;
            length++;
        }
        while(length >= k){ /* how many k window */
            /* reverse between k window */
            ListNode first = pre.next;  /* window begin */
            for(int i = 0; i < k-1; i++){
                ListNode second = first.next;
                first.next = second.next;
                second.next = pre.next;
                pre.next = second;
            }
            pre = first; /* move to the second window */
            length -= k;
        }
        return dummy.next;
    }
}
