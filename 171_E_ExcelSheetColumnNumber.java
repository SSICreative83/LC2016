public class Solution {
    public int titleToNumber(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int res = 0;
        int base = 1;
        for(int i = len - 1; i >= 0; i--) {
            res += base * (s.charAt(i) - 'A' + 1);
            base = base * 26;
        }
        return res;
    }
}
