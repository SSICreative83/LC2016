public class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int[] res = new int[len];
        if(len == 0) return res;
        
        boolean isNine = true;
        for(int i = 0; i < len; i++) {
            if(digits[i] != 9) {
                isNine = false;
                break;
            }
        }
        
        // 9999 case
        if(isNine) {
            res = new int[len + 1];
            res[0] = 1;
            return res;
        }
        
        boolean plusOne = true;
        for(int i = len - 1; i >= 0; i--) {
            int cur = digits[i];
            if(plusOne == true) {
                if(cur == 9) {
                    res[i] = 0;
                } else {
                    res[i] = cur + 1;
                    plusOne = false;
                }
            } else {
                res[i] = cur;
            }
        }
        
        return res;
    }
}
