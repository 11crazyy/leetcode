package test;

import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.Map;

public class BuildTree {
    private int preIndex = 0;
    private Map<Integer, Integer> inorderTreeNodeMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderTreeNodeMap.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, 0, preorder.length - 1);
    }

    public TreeNode buildTreeHelper(int[] preorder, int left, int right) {
        if (left > right) {
            return null;//递归终止条件
        }
        int rootValue = preorder[preIndex++];//根节点在中序遍历中的索引
        TreeNode root = new TreeNode(rootValue);//根节点
        root.left = buildTreeHelper(preorder, left, inorderTreeNodeMap.get(rootValue) - 1);
        root.right = buildTreeHelper(preorder, inorderTreeNodeMap.get(rootValue) + 1, right);
        return root;
    }
}
