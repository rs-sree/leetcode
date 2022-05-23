public class LRUCache {
    Map<Integer, Node> cache;
    DoubleLinkedList linkedList;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.linkedList = new DoubleLinkedList();
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        update(key, cache.get(key));
        return cache.get(key).value;
    }

    public void put(int key, int value) {
        Node n = new Node(key, value);

        if (cache.containsKey(key))
            linkedList.removeNode(cache.get(key));
        else if (cache.size() >= capacity) {
            int k = linkedList.removeTail();
            cache.remove(k);
        }
        linkedList.insertNode(n);
        cache.put(key, n);
    }

    private void update(int key, Node n) {
        linkedList.removeNode(n);
        linkedList.insertNode(n);
        cache.put(key, n);
    }
}


class Node {
    int key, value;
    Node prev, next;

    public Node() {
    }

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}

class DoubleLinkedList {
    Node head, tail;

    public DoubleLinkedList() {
        this.tail = new Node();
        this.head = new Node();
        this.head.next = tail;
        this.tail.prev = head;
    }

    public void insertNode(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    public void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public int removeTail() {
        Node node = tail.prev;
        int key = node.key;
        removeNode(node);

        return key;
    }
}