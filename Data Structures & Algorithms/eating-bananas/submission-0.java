class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[0], r = piles[0];
        for(int n: piles){
            max = Math.max(max, n);
        }
        r = max;
        int a = 1, b = max;
        while(a <= b){
            int m = a + (b - a)/2;
            int t = 0;
            for(int n: piles){
                t += (int)Math.ceil((double)n / m);
            }
            if(t <= h){
                r = Math.min(m, r);
                b = m - 1;
            }else{
                a = m + 1;
            }
        }
        return r;
    }
}
