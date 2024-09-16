package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetMinimumDifference {
    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        order(root, list);
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            res = Math.min(res, list.get(i) - list.get(i - 1));
        }
        return res;
    }

    public void order(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        order(root.left, list);
        list.add(root.val);
        order(root.right, list);
    }
}
