public class LFUCache {
    private Map<Integer, Integer> valHash; /* for just storing key, value pair */
    private Map<Integer, Node> nodeHash; /* key, node pair */
    private Node head; /* doubly LinkedList */
    public final int CAPACITY;

    public LFUCache(int capacity) {
        CAPACITY = capacity;
        valHash = new HashMap<>();
        nodeHash = new HashMap<>();
    }

    public int get(int key) {
        if(valHash.containsKey(key)){
            update(key); /* update the access frequency in the doubly LinkedList */
            return valHash.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if(CAPACITY == 0) return;
        if(valHash.containsKey(key)){
            valHash.put(key, value);
        }else{
            if(valHash.size() < CAPACITY){
                valHash.put(key, value);
            }else{
                evitOld(); /* evict the least frequence used node (the keys in head node's LinkedHashSet) */
                valHash.put(key, value);
            }
            addFront(key);
        }
        update(key); /* exist (update)or not exist(store value), both consider one access */
    }
    public void update(int key){    /* update access frequency, increment count by 1 */
        Node node = nodeHash.get(key);
        node.keys.remove(key); /* first get the location of key's Node, and remove it from LinkedHashSet */

        if(node.next == null){ /* if it is the last node in the last, append a new node at the edn */
            node.next = new Node(node.count+1);
            node.next.keys.add(key);
            node.next.pre = node;
        }else if(node.next.count == node.count+1){ /* if next node is exact one more access more than the current node */
            node.next.keys.add(key);   /* the key should be placed in next node's LinkedHashSet */
        }else{
            /* otherwise just insert a new node after current node */
            Node temp = new Node(node.count+1);
            temp.keys.add(key);
            temp.next = node.next;
            temp.pre = node;
            node.next.pre = temp;
            node.next = temp;
        }
        nodeHash.put(key, node.next); /* update the key reference of the nodeHash */
        if(node.keys.size() == 0){ /* becase we have removed a key from the list, need to check if is empty */
            remove(node); /* if it is empty, remove it */
        }
    }
    /* remove the first key in the head node's keys set */
    public void evitOld(){
        if(head == null) return;
        int delKey = 0;
        for(int n : head.keys){
            delKey = n; /* get the first key in the set and break */
            break;
        }
        head.keys.remove(delKey);
        if(head.keys.size() == 0) remove(head); /* always check empty for previous remove operation */
        nodeHash.remove(delKey); /* update nodeHash */
        valHash.remove(delKey); /* update valHash */
    }
    /* always added at the front in the doubly list */
    public void addFront(int key){
        if(head == null){
            head = new Node(0);
            head.keys.add(key);
        }
        /* here simply create a new node and added to in front of head, because the access
        count is always starting from 1, because we consider inserting as one access */
        Node node = new Node(0);
        node.keys.add(key);
        node.next = head;
        head.pre = node;
        head = node;
        nodeHash.put(key, head); /* a new node is added, create the key reference in the nodeHash */
    }
    /* removing a node in the doubly LinkedList */
    public void remove(Node node){
        if(node.pre == null){
            head = head.next;
        }else{
            node.pre.next = node.next;
        }
        if(node.next != null){
            node.next.pre = node.pre;
        }
    }
    /* define a custome Node to store all the keys that the same access frequency */
    private class Node{
        int count; /* access frequency */
        Set<Integer> keys;  /* keys with the same frequency */
        Node pre, next;
        public Node(int count){
            this.count = count;
            keys = new LinkedHashSet<>();
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
