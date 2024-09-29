package test;

public class Flatten {
    public void flatten(TreeNode root) {
        //左子树接入根节点 右子树接入左子树的最右节点
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode right = root.right;
        if (root.left != null) {//左子树接入根节点
            root.right = root.left;
            root.left = null;
            TreeNode tmp = root.right;
            while (tmp.right != null) {
                tmp = tmp.right;
            }
            tmp.right = right;
        }

    }

    public static void main(String[] args) {
        Flatten flatten = new Flatten();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        flatten.flatten(root);
    }

}
