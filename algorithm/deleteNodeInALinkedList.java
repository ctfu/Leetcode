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

/* Instead of deleting a node, this approach moves the each node value up front */
public class Solution {
    public void deleteNode(ListNode node) {
        ListNode previous = null;
        while(node.next != null){
            node.val = node.next.val;
            previous = node;
            node = node.next;
        }
        previous.next = node.next;

        /* more efficient approach by dirrectly setting the correct node reference as follow: */
        /* if(node.next != null){
              node.value = node.next.value;
              node.next = node.next.next;
            }
        */
    }
}
