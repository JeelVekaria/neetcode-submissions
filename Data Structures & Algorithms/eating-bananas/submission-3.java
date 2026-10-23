class Solution {
    private boolean check(int[] piles, int h, int k) {
        int hrs=0;
        for(int i=0; i<piles.length; i++) {
            hrs+= Math.ceil((piles[i])/(double)k);
        }
        return hrs<=h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int max = Arrays.stream(piles).max().getAsInt();
        int min=1;
        int res = max;

        while(min<=max) {
            int mid = min + (max - min) / 2;

            if(check(piles, h, mid)) {
                res = mid;
                max = mid-1;
            } else {
                min = mid+1;
            }
        }

        return res;
    }
}
