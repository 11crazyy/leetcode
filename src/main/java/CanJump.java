public class CanJump {
    public boolean canJump(int[] nums) {
        int maxPos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxPos) {
                return false;
            }
            maxPos = Math.max(maxPos, i + nums[i]);
            if (maxPos >= nums.length - 1) {
                return true;
            }
        }
        return true;
    }
}
