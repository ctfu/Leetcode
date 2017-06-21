/* Divide and conquer, divide K lists problem into merge two list problem */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        if(lists.length == 1) return lists[0];
        if(lists.length == 2) return merge2Lists(lists[0], lists[1]);
        ListNode[] list1 = new ListNode[lists.length/2];
        System.arraycopy(lists, 0, list1, 0, lists.length/2);
        ListNode first = mergeKLists(list1);

        ListNode[] list2 = new ListNode[lists.length - lists.length/2];
        System.arraycopy(lists, lists.length/2, list2, 0, (lists.length - lists.length/2));
        ListNode second = mergeKLists(list2);
        return merge2Lists(first, second);
    }
    private ListNode merge2Lists(ListNode first, ListNode second){
        if(first == null && second == null) return null;
        if(first == null) return second;
        if(second == null) return first;

        ListNode head = new ListNode(-1);
        ListNode dummy = head;
        while(first != null && second != null){
            if(first.val < second.val){
                head.next = first;
                first = first.next;
            }else{
                head.next = second;
                second = second.next;
            }
            head = head.next;
        }
        if(first != null){
            head.next = first;
        }else{
            head.next = second;
        }
        return dummy.next;
    }
}

/* Method 2: minHeap */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> heap = new PriorityQueue<>(lists.length, new Comparator<ListNode>(){
            @Override
            public int compare(ListNode a, ListNode b){
                return a.val - b.val;
            }
        });
        for(int i = 0; i < lists.length; i++){
            if(lists[i] != null){
                heap.offer(lists[i]);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while(!heap.isEmpty()){
            pre.next = heap.poll();
            pre = pre.next;
            if(pre.next != null){
                heap.offer(pre.next);
            }
        }
        return dummy.next;
    }
}
