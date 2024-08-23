package test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        if (root == null) {
            return result;
        }
        deque.addLast(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode current = deque.pollFirst();
                list.add(current.val);
                if (current.left != null) {
                    deque.addLast(current.left);
                }
                if (current.right != null) {
                    deque.addLast(current.right);
                }
            }
            result.add(list);
        }
        return result;
    }
}
