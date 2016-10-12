/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        /* add the first element to the new list */
        ListNode cur = head;
        ListNode newHead = null;
        ListNode tail = null;
        newHead = tail = cur;
        while(cur.next != null){
            if(cur.val != cur.next.val){
                tail.next = cur.next;
                tail = tail.next;
            }
            cur = cur.next;
        }
        tail.next = null;
        return newHead;
    }
}

/* recursive method */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode newNode = deleteDuplicates(head.next);
        if(newNode == null){
            return head;
        }
        if(head.val != newNode.val){
            head.next = newNode;
            return head;
        }
        return newNode;
    }
}
