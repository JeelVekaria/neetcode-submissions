class Solution {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public void dfs(int[] nums, int target, int idx, int sum) {
        if(sum==target) {
            res.add(new ArrayList<>(path));
            return;
        }
        if(idx>=nums.length || sum>target) {
            return;
        }
        
        path.add(nums[idx]);
        dfs(nums, target, idx, sum+nums[idx]);

        path.remove(path.size()-1);
        dfs(nums, target, idx+1, sum);

    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        dfs(nums, target, 0, 0);
        return res;
    }
}
