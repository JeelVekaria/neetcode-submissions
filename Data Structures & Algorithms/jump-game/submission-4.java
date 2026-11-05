class Solution {
    public boolean dfs(int[] nums, int idx) {
        if(idx<=0) return true;

        int jump=1;
        for(int i=idx-1; i>=0; i--) {
            if(nums[i]>=jump) {
                return dfs(nums, i);
            }
            jump++;
        }
        return false;
    }
    public boolean canJump(int[] nums) {
        return dfs(nums, nums.length-1);
    }
}
