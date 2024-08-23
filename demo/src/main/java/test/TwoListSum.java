package test;

public class TwoListSum {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        int carry = 0;
        ListNode head = null,tail = null;
        while(l1!=null || l2 !=null) {
            int n1 = l1!=null?l1.val:0;
            int n2 = l2!=null?l2.val:0;
            int sum = n1 + n2 + carry;
            carry = sum /10;
            int val = sum % 10;
            if (head == null){
                head = tail = new ListNode(val);
            }else {
                tail.next = new ListNode(val);
                tail = tail.next;
            }
            if (l1!=null){
                l1 = l1.next;
            }
            if (l2!=null){
                l2 = l2.next;
            }
        }
        if (carry == 1){
            tail.next = new ListNode(1);
        }
        return head;
    }
}
