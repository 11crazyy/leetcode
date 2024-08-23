package test;

public class Partition {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode smallDummp = new ListNode(0);
        ListNode largeDummp = new ListNode(0);
        ListNode temp = head, smallTemp = smallDummp, largeTemp = largeDummp;
        while (temp != null) {
            if (temp.val < x) {
                smallTemp.next = temp;
                smallTemp = smallTemp.next;
            } else {
                largeTemp.next = temp;
                largeTemp = largeTemp.next;
            }
            temp = temp.next;
        }
        largeTemp.next = null;
        smallTemp.next = largeDummp.next;
        return smallDummp.next;
    }
}
