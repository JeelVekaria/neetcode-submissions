class Solution {

    public int valid(int i, int[] piles, int h) {
        int total = 0;
        for(int val: piles) {
            int time = (val+(i-1))/i;
            total+=time;
            if(total>h) return -1;
        }
        return i;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int max = Arrays.stream(piles).max().getAsInt();

        int l=1;
        int r=max;
        int lowest = max;

        while(l<=r) {
            int mid = l + (r-l)/2;

            int time = valid(mid,piles,h);
            if(time>0) {
                r=mid-1;
                lowest=time;
            } else {
                l=mid+1;
            }
        }
        return lowest;

    }
}
