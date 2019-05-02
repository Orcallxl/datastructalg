package datastruct.list;

/**
 * Created by orca on 2019/4/22.
 * 单链表反转
 * 环检测
 * 有序链表合并
 * 删除倒数第n个节点
 * 求链表中间节点

 */
public class ListPracCase {
    static class Node{
        Node(int value){
            this.value = value;
        }
        Node pre;
        Node next;
        int value;
    }
    public static void main(String args[]){
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
    }

}
