public class Solution {
    //Time Limit Exceeded
    public int climbStairs1(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
    
    public int climbStairs(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        
        int[] res = new int[n + 1];
        res[0] = 0;
        res[1] = 1;
        res[2] = 2;
        
        for(int i = 3; i < n + 1; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[n];
    }
}
