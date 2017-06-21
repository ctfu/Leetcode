/* seperate the list into two list based on k positon
 * make the second list's tail points to the first list's head */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        int length = 0;
        ListNode cur = head;
        ListNode tail = null;
        while(cur != null){
            tail = cur;     /* get the tail node while calculating length */
            cur = cur.next;
            length++;
        }
        k = k % length;
        if(k == 0){
            return head;
        }
        cur = head;
        for(int i = 0; i < length - k - 1; i++){
           cur = cur.next;
        }
        ListNode newHead = cur.next;
        cur.next = null;
        tail.next = head;
        return newHead;
    }
}
