class Solution {
    List<List<Integer>> list;
    List<Integer> sub;
    // 1, idx=0
    // 1, idx=1,[1], []
    // we do a binary recursive tree search
    // eg. 1,2,3
//                          []
// add1 or []          [1]/       \[]
// add2 or []     [1,2]/ \[1]  [2]/ \[]
// add 3.. etc
    public void dfs(int[] nums, int i){
        if(i>=nums.length) {
            list.add(List.copyOf(sub));
            return;
        }
        sub.add(nums[i]);
        dfs(nums, i+1);

        sub.remove(sub.size()-1);
        dfs(nums, i+1);
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        this.list = new ArrayList<>();
        this.sub = new ArrayList<>();
        dfs(nums, 0);
        return this.list;
    }
}
