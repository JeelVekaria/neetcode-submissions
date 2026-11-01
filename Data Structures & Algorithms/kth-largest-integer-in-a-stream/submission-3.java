class KthLargest {
    PriorityQueue<Integer> list;
    int k;
    public KthLargest(int k, int[] nums) {
        list = new PriorityQueue<>();
        for(int i=0; i<nums.length; i++) {
            list.add(nums[i]);
            if(list.size()>k) list.poll();
        }
        this.k = k;
    }
    
    public int add(int val) {
        list.add(val);
        if(list.size()>k) list.poll();
        return list.peek();
    }
}
