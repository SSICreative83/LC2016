public class Solution {
    public int mySqrt(int x) {
        if(x <= 0)  return 0;
        if(x == 1)  return 1;
        
        int start = 2, end = x / 2;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(x / mid == mid) {
                return mid;
            } else if(x / mid > mid) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if(x / end > end) {
            return end;
        }
        return start;
    }
}
