package test;

public class ChangeListNode {
    public ListNode swapPairs(ListNode head) {
        ListNode dummp = new ListNode(0, head);
        ListNode temp = dummp;
        while (temp.next!=null&&temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = node1.next;
            node1.next = node2.next;
            temp.next = node2;
            node2.next = node1;
            temp = node1;
        }
        return dummp.next;
    }
}
