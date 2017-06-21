/* 1. find the middle node of the list
 * 2. seperate the list into two lists based on the middle node
      (middle belongs to the first list)
 * 3. reverse the second half of the list
 * 4. merge these two lists */
public class Solution {
    public void reorderList(ListNode head) {
        if(head == null) return;
        ListNode middle = findMiddle(head);
        ListNode l2 = middle.next;
        middle.next = null;

        l2 = reverse(l2);
        ListNode l1 = head;
        /* reordering the two lists */
        while(l1 != null && l2 != null){
            ListNode nextNode = l1.next;
            l1.next = l2;
            l2 = l2.next;
            l1.next.next = nextNode;
            l1 = nextNode;
        }
    }
    public ListNode reverse(ListNode head){
        ListNode newHead = null;
        while(head != null){
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
    public ListNode findMiddle(ListNode head){
        /* we can use fast, slow pointer to find middle node */
        int length = 0;
        ListNode cur = head;
        while(cur != null){
            cur = cur.next;
            length++;
        }
        int mid = (length-1)/2;
        cur = head;
        while(mid-- != 0){
            cur = cur.next;
        }
        return cur;
    }
}
