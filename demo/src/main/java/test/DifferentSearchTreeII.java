package test;

import java.util.ArrayList;
import java.util.List;

public class DifferentSearchTreeII {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return generateTree(1, n);
    }

    public List<TreeNode> generateTree(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
            return result;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftNodes = generateTree(start, i - 1);
            List<TreeNode> rightNodes = generateTree(i + 1, end);

            for (TreeNode leftNode : leftNodes) {
                for (TreeNode rightNode : rightNodes) {
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = leftNode;
                    treeNode.right = rightNode;
                    result.add(treeNode);
                }
            }
        }
        return result;
    }
}
