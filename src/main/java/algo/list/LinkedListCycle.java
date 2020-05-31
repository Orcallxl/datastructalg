package algo.list;

/**
 * Created by orca on 2020/5/31.
 * https://leetcode-cn.com/problems/linked-list-cycle
 * 核心思想：
 *  快慢指针，赛车原理
 */
public class LinkedListCycle {
    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public static class Solution{
        public boolean hasCycle(ListNode head) {
            if(head == null || head.next== null) return false;
            ListNode fast = head.next;
            ListNode slow = head;
            while(fast != slow){
                if(fast.next == null || fast.next.next == null) return false;
                fast = fast.next.next;
                slow = slow.next;
            }
            return true;
        }
    }
    public static void main(String args[]){
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node = new ListNode(1,node2);
        node5.next = node3;
        System.out.print(new Solution().hasCycle(node));
    }
}
