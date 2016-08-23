public class Solution {
    public int reverse(int x) {
        boolean isNeg = false;
        long res = 0;
        
        if(x < 0) {
            isNeg = true;
            x = -x;
        }
        
        while (x > 0) {
            int cur = x % 10;
            res = res * 10 + cur;
            x /= 10;
        }
        
        if(res > Integer.MAX_VALUE) {   //overflow case will return 0
            return 0;
        }
        
        if(isNeg) {   // don't forget check negative case at last                  
            return (-1) * (int)res;
        }
        return (int)res;
    }
}
