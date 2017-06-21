/* Requirement: Remove duplicate, so that each element appears once */
/* This question is very similar to "removeLinkedListElement"*/
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        /* we dont need a dummy here, because even if head is duplicated
         * we can keep the head due to the question requirement */
        ListNode pre = head;
        while(pre.next != null){
            if(pre.val == pre.next.val){
                pre.next = pre.next.next;
            }else{
                pre = pre.next;
            }
        }
        return head;
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
