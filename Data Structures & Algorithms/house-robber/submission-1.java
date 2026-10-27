class Solution {
    public int rob(int[] nums) {
        // 90 1 1 90 100
        int[] dp = new int[nums.length];
        
        if(nums.length==1) return nums[0];
        if(nums.length==2) return nums[0]>nums[1]?nums[0]:nums[1];
        if(nums.length==3) return nums[0]+nums[2]>nums[1]?nums[0]+nums[2]:nums[1];

        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = nums[0]+nums[2]>nums[1]?nums[0]+nums[2]:nums[1];

        for(int i=3; i<nums.length;i++) {
            if(nums[i]+dp[i-2]>=nums[i]+dp[i-3]) {
                dp[i] = nums[i]+dp[i-2];
            } else {
                dp[i] = nums[i]+dp[i-3];
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
