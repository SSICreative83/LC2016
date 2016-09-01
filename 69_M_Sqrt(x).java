public class Solution {
    public int mySqrt(int x) {
        if(x <= 0)  return 0;
        
        int res = 1;
        for(int i = 1, j = x/2; i <= j;) {
            int mid = i + (j - i) / 2;
            
            if(x / mid == mid) {
                res = mid;
                return res;
            } else if(x / mid > mid) {
                i = mid + 1;
                res = mid;
            } else {
                j = mid - 1;
            }
        }
        
        return res;
    }
}
