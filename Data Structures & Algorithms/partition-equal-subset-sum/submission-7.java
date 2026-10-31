class Solution {
    int total = 0;


    public boolean dfs(int[] nums, int idx, int sum) {
        if(sum == (total/2)) return true; // no need to keep searching if we found goal
        
        if(idx>=nums.length) {
            return false;
        }

        // left branch: add next element
        if(dfs(nums, idx+1, sum+nums[idx])) return true;
        // right branch: dont add anything
        if(dfs(nums, idx+1, sum)) return true;
        
        return false;
    }

    public boolean canPartition(int[] nums) {
        // get total
        for(int x: nums) total+=x;
        if(total%2==1) return false; // if total is odd, cant evenly split

        // call dfs
        return dfs(nums, 0, 0);
    }
}