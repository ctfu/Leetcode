/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null) {
    		return false;
    	}

    	ListNode current = head;
    	while(current != null) {

    		if(current.next == head) {
    			return true;
    		}
    		ListNode temp = current.next;
    		current.next = head; //set every node points to the head
    		current = temp;
    	}

    	return false;
    }
}

/* fast, slow pointer solution */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while(fast != null){
            if(fast.next != null){
                fast = fast.next.next;
            }else{
                return false;
            }
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
}
