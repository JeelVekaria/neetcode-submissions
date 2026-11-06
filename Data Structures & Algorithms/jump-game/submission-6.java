class Solution {
    public boolean canJump(int[] nums) {
        // main intuition, start at end and move backwards
        // -1 per idx until we reach 0 and seeing if each
        // iteration is able to reach the end or a path to end
        boolean[] dp = new boolean[nums.length];
        dp[dp.length-1]=true;
        // start from end and go towards 0 checking if each idx can jump forward
        for(int i=dp.length-2; i>=0; i--) {
            if(nums[i]==0) continue;
            // can range of jump to next idx that has a path to end
            for(int j=i+1; j<nums[i]+i+1; j++) {
                if(j>=nums.length) break;
                if(dp[j]) {
                    dp[i]=true;
                    break;
                }
            }
        }

        return dp[0];
    }
}
