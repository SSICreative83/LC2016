public class Solution {

    // Time limit exceeded
    // Try one by one from big to small
    public int numSquares(int n) {
        
        if(n <= 0) {
            return -1;
        }
        
        return canFinish(n, 0, (int)Math.sqrt(n));
    }
    
    public int canFinish(int n, int res, int end) {
        if(n == 0) {
            return res;
        }
        
        if(n > 0 && end <= 0) { //not found
            return Integer.MAX_VALUE;
        }
        
        int result = 0;
        
        if(end * end <= n) {
            int tmpRes = res + 1;
            int newn = n - end * end;
            int res1 = canFinish(newn, tmpRes, end);    //take end
                
            int res2 = canFinish(n, res, end - 1); //not take end
            result = Math.min(res1, res2);
        } else {
            int res3 = canFinish(n, res, end - 1);
            return res3;
        }
               
        return result;
    }
}
