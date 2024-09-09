package test;

public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        //以升序序列的中间元素作为根节点 root，递归的构建 root 的左子树与右子树
        return dfs(nums, 0, nums.length - 1);
    }

    public TreeNode dfs(int[] nums, int leftIndex, int rightIndex) {
        if (leftIndex > rightIndex) {
            return null;
        }
        int mid = (leftIndex + rightIndex) / 2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = dfs(nums, leftIndex, mid - 1);
        treeNode.right = dfs(nums, mid + 1, rightIndex);
        return treeNode;
    }
}
