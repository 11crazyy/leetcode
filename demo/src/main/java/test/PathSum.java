package test;

public class PathSum {
    public int pathSum(TreeNode root, int targetSum) {
        //遍历每个节点开头的路径 查找和为targetSum的路径数总和
        if (root == null) {
            return 0;
        }
        int res = sum(root, targetSum);
        res += pathSum(root.left, targetSum);
        res += pathSum(root.right, targetSum);
        return res;
    }
    public int sum(TreeNode node, int targetSum) {
        if (node == null) {
            return 0;
        }
        int res = 0;
        if (node.val == targetSum) {
            res++;
        }
        res += sum(node.left, targetSum - node.val);
        res += sum(node.right, targetSum - node.val);
        return res;
    }
}
