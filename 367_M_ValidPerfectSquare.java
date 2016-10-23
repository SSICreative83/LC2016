public class Solution {
    public boolean isPerfectSquare(int num) {
        
        if(num == 1)    return true;
        
        long low = 1, high = num / 2, mid = 0;  //need to convert to long, test case: 808201
        long newnum = (long)num;
        
        while(low <= high) {
            mid = low + (high - low) / 2;
            if(mid * mid == newnum)    return true;
            if(mid * mid < newnum) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return false;
    }
}
