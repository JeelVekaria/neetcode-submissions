class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int x: stones) maxHeap.add(x);

        while(maxHeap.size()>1) {
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();
            int dif = Math.abs(stone1-stone2);
            maxHeap.add(dif);

        }
        return maxHeap.peek();
    }
}
