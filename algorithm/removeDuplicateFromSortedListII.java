/* Follow up: remove duplicates leaving only the distinct value */
public class Solution{
    public ListNode deleteDuplicates(ListNode root){
        if(root == null) return null;
        /* since removing all duplicates, the head can be removed, need dummy */
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        while(pre.next != null && pre.next.next != null){
            if(pre.next.val == pre.next.next.val){
                int removeVal = pre.next.val;
                /* here is the process of removing duplicates */
                while(pre.next != null && pre.next.val == removeVal){
                    pre.next = pre.next.next;
                }
            }else{
                pre = pre.next;
            }
        }
        return dummy.next;
    }
}
