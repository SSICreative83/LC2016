public class Solution {
    public int reverse1(int x) {
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
            
            if(res > Integer.MAX_VALUE) {       //can also check overflow on the fly
                return 0;
            }   
            x /= 10;
        }
        
        if(isNeg) {
            return (-1) * (int)res;
        }
        return (int)res;
    }
}
