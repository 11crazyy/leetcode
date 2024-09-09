package test;

import java.util.ArrayList;
import java.util.List;

public class KthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> nums = new ArrayList<>();
        order(root, nums, k);
        return nums.get(k - 1);
    }

    public void order(TreeNode node, List<Integer> nums, int target) {
        if (node == null || nums.size() == target) {
            return;
        }
        order(node.left, nums, target);
        nums.add(node.val);
        order(node.right, nums, target);
    }
}
