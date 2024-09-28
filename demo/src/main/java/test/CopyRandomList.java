package test;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {
    public Node copyRandomList(Node head) {
        //先用一个循环把新旧链表对应的两个节点捆绑在一起 再用一个循环完成对新节点每个节点的next域和random域的赋值
        if (head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Node tmp = head;
        while (tmp != null) {
            map.put(tmp, new Node(tmp.val));
            tmp = tmp.next;
        }
        Node cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}
