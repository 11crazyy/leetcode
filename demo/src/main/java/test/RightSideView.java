package test;

import java.util.ArrayList;
import java.util.List;

public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        //右子树的右节点 或没有右子树的那层的左节点
        List<Integer> res = new ArrayList<>();
        order(res, root, 0);
        return res;
    }

    public void order(List<Integer> res, TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if (depth == res.size()) {
            res.add(node.val);
        }
        order(res, node.right, depth + 1);
        order(res, node.left, depth + 1);
    }
}
