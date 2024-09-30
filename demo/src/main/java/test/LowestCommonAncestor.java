package test;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;//找到p或q则结束递归
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);//递归左子树
        TreeNode right = lowestCommonAncestor(root.right, p, q);//递归右子树
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }
}
