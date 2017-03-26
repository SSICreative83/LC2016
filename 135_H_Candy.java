public class Solution {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0) {
            return 0;
        }
        
        int len = ratings.length;
        int[] candies = new int[len];
        for(int i = 0; i < len; i++) {
            candies[i] = 1;
        }
        
        for(int i = 1; i < len; i++) {
            if(ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        
        for(int i = len - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
                candies[i] = candies[i + 1] + 1;
            }
        }
        
        int res = 0;
        for(int i = 0; i < len; i++) {
            res += candies[i];
        }
        
        return res;
    }
}
