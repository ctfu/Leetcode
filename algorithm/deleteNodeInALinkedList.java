/* Author: ctfu   */
/* Title: Delete node in a Linked List */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Solution {
    public void deleteNode(ListNode node) {
        if(node == null) return;
        if(node.next == null){ /* is the node at the edn */
            node = null;
        }else{
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}
