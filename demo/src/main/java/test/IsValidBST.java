package test;

public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    public boolean helper(TreeNode root, Long max, Long min) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return helper(root.left, (long) root.val, min) && helper(root.right, max, (long) root.val);
    }

}
