public class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        if(s.length() == 0)    return false;
        
        if(s.charAt(0) == '+' || s.charAt(0) == '-') {
            s = s.substring(1);
        }
        
        boolean isNum = false;
        boolean isE = false;
        boolean isDot = false;
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c >= '0' && c <= '9') {
                isNum = true;
            } else if(c == '.') {
                if(!isE && !isDot) {
                    isDot = true;
                } else {
                    return false;
                }
            } else if(c == 'e') {
                if(isNum && !isE) {
                    isE = true;
                    isNum = false;
                } else {
                    return false;
                }
            } else if(c == '+' || c == '-') {
                if(i == 0 || s.charAt(i - 1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
        }
        
        return isNum;
    }
}
