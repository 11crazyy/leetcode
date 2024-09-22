package test;

import java.util.HashMap;
import java.util.Map;

public class BuildTreeII {
    private Map<Integer, Integer> inorderMap = new HashMap<>();
    private int postIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //左根右 左右根
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        postIndex = postorder.length - 1;
        return buildTreeHelper(postorder, 0, postorder.length - 1);
    }

    public TreeNode buildTreeHelper(int[] postorder, int left, int right) {
        if (left > right) {
            return null;
        }
        int rootval = postorder[postIndex--];
        int rootIndex = inorderMap.get(rootval);
        TreeNode root = new TreeNode(rootval);
        root.right = buildTreeHelper(postorder, rootIndex + 1, right);
        root.left = buildTreeHelper(postorder, left, rootIndex - 1);
        return root;
    }
}
