package test;

public class DeleteNNode {
    //双指针
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummyNode;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        while (first != null){
            second = second.next;
            first = first.next;
        }
        second.next = second.next.next;
        ListNode newNode = dummyNode.next;
        return newNode;
    }
}
