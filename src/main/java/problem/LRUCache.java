package problem;


import java.util.Hashtable;

/**
 * 使用数据结构：秒杀访问：hashmap、排序：双向链表
 * 如何解决具体问题：
 *  1、如何快速找到队首和队尾节点？--》添加head和tail节点
 * 要注意的细节问题：
 *  1、链表中移动节点一定是两步：处理旧位置的指针+处理新位置的指针，缺一不可
 * Created by orca on 2018/12/9.
 * lru-cache
 * https://leetcode.com/problems/lru-cache/description/
 */
class LRUCache {
    //之前写的一版，写复杂了
//    class Node {
//        public Node(int key, int value) {
//            this.key = key;
//            this.value = value;
//        }
//
//        Node pre;
//        int key;
//        int value;
//        Node next;
//    }
//
//    Node head = null;
//    Node end = null;
//
//    int capacity;
//    HashMap<Integer, Node> map = new HashMap<Integer, Node>();
//
//    public LRUCache(int capacity) {
//        this.capacity = capacity;
//    }
//
//    public int get(int key) {
//        if (map.containsKey(key)) {
//            Node n = map.get(key);
//            remove(n);
//            setHead(n);
//            return n.value;
//        }
//        return -1;
//    }
//
//    private void setHead(Node n) {
//        n.next = head;
//        n.pre = null;
//        if (head != null) {
//            head.pre = n;
//        }
//        head = n;
//        if (end == null) {
//            end = head;
//        }
//    }
//
//    //java空指针检测来决定代码逻辑走向
//    private void remove(Node n) {
//        if (n.pre != null) {
//            n.pre.next = n.next;
//        } else {
//            head = n.next;
//        }
//        if (n.next != null) {
//            n.next.pre = n.pre;
//        } else {
//            end = n.pre;
//        }
//    }
//
//
//    public void put(int key, int value) {
//        if (map.containsKey(key)) {
//            Node old = map.get(key);
//            old.value = value;
//            remove(old);
//            setHead(map.get(key));
//        } else {
//            Node created = new Node(key, value);
//            if (map.size() >= capacity) {
//                map.remove(end.key);
//                remove(end);
//                setHead(created);
//            } else {
//                setHead(created);
//            }
//            map.put(key, created);
//        }
//    }

    class Node{
        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
        private Integer key;
        private Integer value;
        private Node next;
        private Node pre;
    }
    private Hashtable<Integer, Node> table ;
    private Integer capacity;
    private Node tail = new Node(null, null);
    private Node head = new Node(null, null);

    public LRUCache(int capacity) {
        table = new Hashtable<Integer, Node>();
        this.capacity = capacity;
        tail.pre = head;
        head.next =tail;
    }

    public int get(int key) {
        if(table.get(key)!=null){
            Integer value = table.get(key).value;
            put(key, value);
            return  value;
        }
        else {
            return -1;
        }
    }

    public void put(int key, int value) {
        Node node = table.get(key);
        if(node!=null){
            //移到队首,更新table
            node.next.pre = node.pre;
            node.pre.next = node.next;
            node.next = head.next;
            node.pre = head;
            head.next.pre = node;
            head.next = node;
            node.value=value;
        }
        else{
            //超出存储，移除队尾，移除table
            if(table.size()==capacity){
                table.remove(tail.pre.key);
                tail.pre.next = null;
                tail = tail.pre;
            }
            //放入队尾，插入table
//            node = new Node(key,value);
//            node.next = tail;
//            node.pre = tail.pre;
//            tail.pre.next = node;
//            tail.pre = node;
//            table.put(key, node);
            //或者放入队首，插入table
            node = new Node(key,value);
            node.next = head.next;
            node.pre = head;
            head.next.pre = node;
            head.next = node;
            table.put(key, node);
        }
    }
}
