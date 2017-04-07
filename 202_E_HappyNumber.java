public class Solution {
    public boolean isHappy(int n) {
        
        if(n <= 0) {
            return false;
        }
        
        Set<Integer> set = new HashSet<>();
        int tmp = n;
        while(digitSum(tmp) != 1) {
            int cur = digitSum(tmp);
            if(set.contains(cur)) {
                return false;
            } else {
                set.add(cur);
            }
            tmp = cur;
        }
        
        return true;
    }
    
    public int digitSum(int n) {
        int res = 0;
        while(n > 0) {
            int digit = n % 10;
            res += digit * digit;
            n = n / 10;
        }
        return res;
    }
}
