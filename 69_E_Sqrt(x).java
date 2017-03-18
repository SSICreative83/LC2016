public class Solution {
    //self 
    public int mySqrt(int x) {
        if(x <= 0) {
            return 0;
        }
        
        int start = 1, end = x / 2;
        int res = 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(x / mid == mid) {
                res = mid;
                break;
            } else if(x / mid < mid) {
                end = mid - 1;
            } else {
                start = mid + 1;
                res = mid;
            }
        }
        
        return res;
    }
    
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
    
    //jiuzhang
    public int sqrt(int x) {
        // find the last number which square of it <= x
        long start = 1, end = x;
        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            if (mid * mid <= x) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (end * end <= x) {
            return (int) end;
        }
        return (int) start;
    }
}
