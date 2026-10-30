class Solution {
    List<List<Integer>> res;
    List<Integer> path;

    public void dfs(int[] nums, int target, int idx, int sum) {
        int curSum = sum;
        for(int i=idx; i<nums.length; i++) {
            curSum+= nums[i];
            path.add(nums[i]);
            if(curSum<target) {
                dfs(nums, target, i, curSum);
                path.remove(path.size()-1);
                curSum-=nums[i];
            } else if (curSum>target) {
                path.remove(path.size()-1);
                break;
            } else {
                res.add(List.copyOf(path));
                path.remove(path.size()-1);
                break;
            }
        }

    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        path = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, target, 0, 0);


        return res;
    }
}
