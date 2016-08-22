public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int min = prices[0];
        int maxP = 0;
        
        for(int i = 0; i < prices.length; i++) {
            int cur = prices[i];
            maxP = Math.max(maxP, cur - min);
            min = Math.min(min, cur);
        }
        
        return maxP;
    }
}
