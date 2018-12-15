package problem;


import java.util.HashMap;

/**
 * Created by orca on 2018/12/9.
 * lru-cache
 * https://leetcode.com/problems/lru-cache/description/
 */
class LRUCache {
    class Node {
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        Node pre;
        int key;
        int value;
        Node next;
    }

    Node head = null;
    Node end = null;

    int capacity;
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            remove(n);
            setHead(n);
            return n.value;
        }
        return -1;
    }

    private void setHead(Node n) {
        n.next = head;
        n.pre = null;
        if (head != null) {
            head.pre = n;
        }
        head = n;
        if (end == null) {
            end = head;
        }
    }

    //java空指针检测来决定代码逻辑走向
    private void remove(Node n) {
        if (n.pre != null) {
            n.pre.next = n.next;
        } else {
            head = n.next;
        }
        if (n.next != null) {
            n.next.pre = n.pre;
        } else {
            end = n.pre;
        }
    }


    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node old = map.get(key);
            old.value = value;
            remove(old);
            setHead(map.get(key));
        } else {
            Node created = new Node(key, value);
            if (map.size() >= capacity) {
                map.remove(end.key);
                remove(end);
                setHead(created);
            } else {
                setHead(created);
            }
            map.put(key, created);
        }
    }
}
