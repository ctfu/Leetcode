/* use reverse between window concept
 * move to the position where window begins (nodes < x)
 * use first, second to partition */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        while(pre.next != null && pre.next.val < x){
            pre = pre.next;
        }
        ListNode first = pre.next;  /* windows begins */
        while(first != null && first.next != null){ /* window size condition */
            if(first.next.val < x){
                ListNode second = first.next;
                first.next = second.next;
                second.next = pre.next;
                pre.next = second;
                pre = pre.next; /* move pre forward */
            }else{
                first = first.next;
            }
        }
        return dummy.next;
    }
}
