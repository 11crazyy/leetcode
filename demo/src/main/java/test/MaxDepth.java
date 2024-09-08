package test;

public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftLen = maxDepth(root.left);
        int rightLen = maxDepth(root.right);
        return Math.max(leftLen, rightLen) + 1;
    }
}
