package test;

public class DiameterOfBinaryTree {
    private int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode node) {
        //最大直径=左子树链长+右子树链长
        if (node == null) {
            return -1;
        }
        int lLen = dfs(node.left) + 1;
        int rLen = dfs(node.right) + 1;
        ans = Math.max(ans, lLen + rLen);
        return Math.max(lLen, rLen);
    }
}
