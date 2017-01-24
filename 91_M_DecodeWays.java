public class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0)    return 0;
        
        int[] res = new int[s.length() + 1];
        res[0] = 1;
        if(isValid(s.substring(0,1))) {
            res[1] = 1;
        } else {
            res[1] = 0;
        }
        for(int i = 2; i <= s.length(); i++) {
            if(isValid(s.substring(i - 1, i))) {  //eg. "23", "3" is valid, res[2] = res[1], res[2] = 1
                res[i] = res[i - 1];
            } 
            if(isValid(s.substring(i - 2, i))) {  //eg. "23", "23" is valid, res[2] += res[0], res[2] = 2
                res[i] += res[i - 2];
            }
        }
        return res[s.length()]; //res[n] is number of ways to decode for string length n

    }
    
    public boolean isValid(String s) {
        if(s == null || s.length() == 0 || s.length() > 2)    return false;
        if(s.charAt(0) == '0')  return false;
        if(s.length() == 1) return true;
        int val = (s.charAt(0) - '0') * 10 + (s.charAt(1) - '0');
        if(val > 26 || val < 1) return false;
        return true;
    }
    
    //Recursion, time limit exceeded
    public int numDecodings(String s) {
        if(s == null || s.length() == 0)    return 0;
        if(s.length() == 1) return isValid(s) ? 1 : 0;
        int res = 0;
        if(s.length() == 2) {
            if(isValid(s.substring(0, 1)) && isValid(s.substring(1, 2))) {
                res += 1;
            }
            if(isValid(s)) {
                res += 1;
            }
            return res;
        }
        
        if(isValid(s.substring(0, 1))) {
            res += numDecodings(s.substring(1));
        }
        if(isValid(s.substring(0, 2))) {
            res += numDecodings(s.substring(2));
        }
        
        return res;
    }
    
    public boolean isValid(String s) {
        if(s == null || s.length() == 0)    return false;
        if(s.length() > 2)  return false;
        if(s.charAt(0) == '0')  return false;
        
        Integer in = Integer.parseInt(s);
        return in >= 1 && in <= 26;
    }
}
