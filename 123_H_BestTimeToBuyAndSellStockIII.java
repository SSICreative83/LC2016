public class Solution {
    //http://blog.csdn.net/fightforyourdream/article/details/14503469
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len < 2)    return 0;
        
        int[] max_to_cur_front = new int[prices.length];
        int[] max_to_cur_back = new int[prices.length];
        
        int min_to_now = prices[0];
        for(int i = 1; i < prices.length; i++) {
            max_to_cur_front[i] = Math.max(max_to_cur_front[i - 1], prices[i] - min_to_now);
            min_to_now = Math.min(min_to_now, prices[i]);
        }
        
        int max_to_now = prices[prices.length - 1];
        for(int i = prices.length - 2; i >= 0; i--) {
            max_to_cur_back[i] = Math.max(max_to_cur_back[i + 1], max_to_now - prices[i]);
            max_to_now = Math.max(max_to_now, prices[i]);
        }
        
        int res = 0;
        for(int i = 0; i < prices.length; i++) {
            res = Math.max(res, max_to_cur_front[i] + max_to_cur_back[i]);
        }
        
        return res;
    }
}
