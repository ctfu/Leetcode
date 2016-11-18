/* Solution concept:
1. The list length is longer, the probability of return each node should be smaller
2. if the list contains one node, probability of return this node 1/1 (100%)
3. if the list contains two node, the probability of return each node is 1/2 (50%), and so on...
Example:
the return value is "r = head.val"
when read the first node, if head.next == null, stop and return r.
when read the second node, we can decide if we should replace r with second node, the chances of replacing is 1/2,
so we set up a random value between [0,1] if value obtained is 1, then replace r
when read the third node, we can decide again, the changes of replacing is 1/3,
so we set up a random value between [0, 3], if value obtained is 3, then replace r */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Solution {
    ListNode head;
    public Solution(ListNode head) {
        this.head = head;
    }

    /** Returns a random node's value. */
    public int getRandom() {
        ListNode cur = head;
        int r = cur.val;
        for(int i = 1; cur.next != null; i++){
            cur = cur.next;
            if(genRandom(i) == i) r = cur.val;
        }
        return r;
    }
    private int genRandom(int max){
        return (int)(Math.random() * (max + 1));
    }
}
