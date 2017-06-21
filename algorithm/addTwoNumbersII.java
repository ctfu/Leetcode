/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 /* use stack, without midifying the list */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while(l1 != null){
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            stack2.push(l2.val);
            l2 = l2.next;
        }
        ListNode head = new ListNode(0);
        int sum = 0;
        while(!stack1.empty() || !stack2.empty()){
            if(!stack1.empty()) sum += stack1.pop();
            if(!stack2.empty()) sum += stack2.pop();
            head.val = sum % 10;
            /* take care of carry */
            ListNode carry = new ListNode(sum / 10);
            carry.next = head;
            head = carry;
            sum /= 10;/* get the carry */
        }
        return head.val == 0 ? head.next : head;
    }
}

/* recursive solution */
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      int size1 = getLength(l1);
      int size2 = getLength(l2);
      ListNode head = new ListNode(1);
      // Make sure l1.length >= l2.length
      head.next = size1 < size2 ? helper(l2, l1, size2 - size1) : helper(l1, l2, size1 - size2);
      // Handle the first digit
      if (head.next.val > 9) {
          head.next.val = head.next.val % 10;
          return head;
      }
      return head.next;
  }
  // get length of the list
  public int getLength(ListNode l) {
      int count = 0;
      while(l != null) {
          l = l.next;
          count++;
      }
      return count;
  }
  // offset is the difference of length between l1 and l2
  public ListNode helper(ListNode l1, ListNode l2, int offset) {
      if (l1 == null) return null;
      // check whether l1 becomes the same length as l2
      ListNode result = offset == 0 ? new ListNode(l1.val + l2.val) : new ListNode(l1.val);
      ListNode post = offset == 0 ? helper(l1.next, l2.next, 0) : helper(l1.next, l2, offset - 1);
      // handle carry
      if (post != null && post.val > 9) {
          result.val += 1;
          post.val = post.val % 10;
      }
      // combine nodes
      result.next = post;
      return result;
  }
