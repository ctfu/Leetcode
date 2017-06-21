/* Method 1: LinkedHashMap, and override removeEldestEntry method */
public class LRUCache {
    private Map<Integer, Integer> lhm;
    public final int CAPACITY;
    public LRUCache(int capacity) {
        CAPACITY = capacity;
        /* construct a new LinkedHashMap and override the removeEldestEntry */
        lhm = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest){
                return size() > CAPACITY;
            }
        };
    }

    public int get(int key) {
        return lhm.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        lhm.put(key, value);
    }
}

/* Method 2: HashMap<Integer, Node> + Doubly LinkedList */
public class LRUCache {
    private Map<Integer, Node> hm;
    private Node head, tail; /* head, tail for doubly LinkedList */
    private int size; /* List size */
    public final int CAPACITY;

    public LRUCache(int capacity) {
        CAPACITY = capacity;
        hm = new HashMap<>();
        size = 0;
        /* initialized the doubly LinkedList */
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if(!hm.containsKey(key)){
            return -1;
        }
        Node node = hm.get(key);
        update(node); /* the node has been access, move it to the front */
        return node.val;
    }

    public void put(int key, int value) {
        if(!hm.containsKey(key)){
            Node node = new Node(key, value);
            hm.put(key, node);
            addFront(node); /* dont forget to add to the list */
            size++;
            if(size > CAPACITY){
                Node deleted = tail.pre; /* always delete from the tail */
                remove(deleted);
                hm.remove(deleted.key);
                size--;
            }
        }else{ /* if exists in the map, it is just an update operation (access the node)*/
            Node node = hm.get(key);
            node.val = value;
            update(node);
        }
    }
    /* delete the node and move it to the front */
    private void update(Node node){
        remove(node);
        addFront(node);
    }
    /* always added at the front */
    private void addFront(Node node){
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
    }
    private void remove(Node node){
        node.next.pre = node.pre;
        node.pre.next = node.next;
    }
    /* List node definition*/
    private class Node{
        int key;
        int val;
        Node pre;
        Node next;

        public Node(int key, int value){
            this.key = key;
            this.val = value;
        }
    }
}
