/* create a new list, insert the target list one by one to the new list */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-1); /* a new list */
        ListNode pre = dummy;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            while(pre.next != null && pre.next.val <= cur.val){
                pre = pre.next;
            }
            cur.next = pre.next;
            pre.next = cur;
            pre = dummy;
            cur = next;
        }
        return dummy.next;
    }
}
