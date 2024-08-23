package test;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(result, root);
        return result;
    }

    public void inorder(List<Integer> result, TreeNode root) {
        if (root != null) {
            inorder(result, root.left);
            result.add(root.val);
            inorder(result, root.right);
        }
    }
}