package test;

public class RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) return head;
        //连成环 找到第len-1-(k%len)个节点 断开链表
        int len = 1;
        ListNode temp = head;
        while (temp.next != null) {
            len++;
            temp = temp.next;
        }
        //连环
        temp.next = head;
        ListNode newTail = head;
        k %= len;
        for (int i = 0; i < len - 1 - k; i++) {
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;
        //断开
        newTail.next = null;
        return newHead;
    }
}
