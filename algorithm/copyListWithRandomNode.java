/* The difficult is to deep copy the random pointer:
 * 1 -> 2 -> 3 ->null (original)
 * 1 -> 2 -> 3 ->null (copy)
 * if Node(1).random -> 3, copy list cannot find 3
 * Solution: HashMap<originNode, new copyNode> to build a connection
 * between original 3 and copy 3. o(n), s(n) */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        Map<RandomListNode, RandomListNode> hm = new HashMap<>();
        RandomListNode cur = head;
        /* copy Node */
        while(cur != null){
            hm.put(cur, new RandomListNode(cur.label));
            cur = cur.next;
        }
        cur = head;
        /* copy next and copy random */
        while(cur != null){
            hm.get(cur).next = hm.get(cur.next);
            hm.get(cur).random = hm.get(cur.random);
            cur = cur.next;
        }
        return hm.get(head);
    }
}

/* o(n), space o(1) solution by maintianing a singly linkedlist between original
 * list and copy: 1  2  3
 *                | /| /|
 *                1  2  3  so that copy node follow immediately by original node */

 public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null ) return null;
        RandomListNode cur = head;
        /* copy node and associate copy */
        while(cur != null){
            RandomListNode next = cur.next;
            RandomListNode copy = new RandomListNode(cur.label);
            cur.next = copy;
            copy.next = next;
            cur = next;
        }
        /* copy random */
        cur = head;
        while(cur != null){
            if(cur.random != null){/* random node could point to null */
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        /* separate original and copy list */
        cur = head;
        RandomListNode dummy = new RandomListNode(-1);
        RandomListNode pre = dummy;
        while(cur != null){
            RandomListNode next = cur.next.next;
            pre.next = cur.next;
            pre = pre.next;
            cur.next = next;
            cur = next;
        }
        return dummy.next;
    }
}
