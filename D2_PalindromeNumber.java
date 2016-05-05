public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        
        long len = 1;
        int temp = x;
        while(temp > 0) {
            temp = temp / 10;
            len = len * 10;         //caution: this will overflow!
        }
        if(len == 1 || len == 10) { //0 or single digit
            return true;
        } else {
            len = len / 10; //if x = 12, len = 10; x = 123, len = 100
        }
        while(x > 0) {
            int last = x % 10;
            int first = x / (int)len;
            if(last != first) {
                return false;
            }
            x = x % (int)len; //get remaining digits except first one
            x = x / 10;
            len = len / 100;
        }
        
        return true;
    }
}
