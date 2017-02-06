public class Solution {
    //Time Limit Exceeded
    public double myPow1(double x, int n) {
        if(x == 0.0) {
            return 0.0;
        }
        if(n == 0) {
            return 1;
        }
        if(n == 1) {
           return x; 
        }
        if(n < 0) {
            return 1 / myPow(x, -n);
        }
        
        boolean isNeg = false;
        if(x < 0 && n % 2 != 0) {
            isNeg = true;
            x = -x;
        }
        
        double res = 0;
        if(n % 2 == 0) {
            res = myPow(x, n / 2) * myPow(x, n / 2);
        } else {
            res = x * myPow(x, (n - 1) / 2) * myPow(x, (n - 1) / 2);
        }
        
        return isNeg? -res : res;
    }
    
    public double myPow(double x, int n) {
        if(x == 0)  return 0;
        if(n == 0)  return 1;
        if(n == 1)  return x;
        
        int pn = n < 0 ? -n : n;
        double px = x < 0 ? -x : x;
        int pn2 = pn;
        int exp = 1;
        double res = px;
        
        while(pn2 / 2 > 0) {    //key part is this, not only divide by 2, but divide by ^2
            pn2 /= 2;
            exp *= 2;
            res = res * res;
        }
        res = res * myPow(px, pn - exp);
        
        if(x < 0 && n % 2 != 0) res = -res;
        if(n < 0)   res = 1/res;
        return res;
    }
}
