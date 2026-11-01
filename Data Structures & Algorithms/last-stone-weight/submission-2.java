class Solution {
    public int lastStoneWeight(int[] stones) {
        int x = 0;
        if(stones.length==1) return stones[0];
        Arrays.sort(stones);
        for(int i=stones.length-1; i>0; i--) {
            int s1 = stones[i];
            int s2 = stones[i-1];
            x = Math.abs(s1-s2);
            stones[i-1] = x;
            Arrays.sort(stones);
        }
        return stones[0];
    }
}
