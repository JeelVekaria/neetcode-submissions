class KthLargest {
    PriorityQueue<Integer> list;
    int k;
    public KthLargest(int k, int[] nums) {
        list = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<nums.length; i++) {
            list.add(nums[i]);
        }
        this.k = k;
    }
    
    public int add(int val) {
        list.add(val);
        int kthMax = 0;
        List<Integer> popped = new ArrayList<>();
        for(int i=0; i<k-1; i++) {
            popped.add(list.poll());
        }
        kthMax = list.poll();
        popped.add(kthMax);
        for(int x: popped) list.add(x);
        return kthMax;
    }
}
