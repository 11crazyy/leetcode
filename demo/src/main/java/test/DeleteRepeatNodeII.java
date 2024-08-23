package test;

public class DeleteRepeatNodeII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode dummp = new ListNode(0, head);
        ListNode temp = dummp;
        while (temp.next != null && temp.next.next != null) {
            if (temp.next.val == temp.next.next.val) {
                int target = temp.next.val;
                while (temp.next != null && temp.next.val == target) {
                    temp.next = temp.next.next;
                }
            } else {
                temp = temp.next;
            }
        }
        return dummp.next;
    }
}
