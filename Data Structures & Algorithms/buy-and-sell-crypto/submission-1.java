class Solution {
    public int maxProfit(int[] prices) {
        //decreasing
        //min so far
        int p = 0, l = 0, r = 0;
        while(r < prices.length - 1){
            p = Math.max(p, (prices[r] - prices[l]));
            if(prices[r] < prices[l]){
                    l = r;
            }
            r++;
        }
        if(prices[r] > prices[Math.max(0,r - 1)]){
            p = Math.max(p, (prices[r] - prices[l]));
        } 
        return p;  
    }
}
