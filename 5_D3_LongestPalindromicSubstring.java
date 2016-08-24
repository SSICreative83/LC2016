public class Solution {
    //naive solution, time out
    public String longestPalindrome1(String s) {
        if(s == null || s.length() == 0)    return "";
        String max = "";
        
        for(int i = 0; i <  s.length(); i++) {
            for(int j =  s.length() - 1; j >= 0; j--) {
                String subs = s.substring(i, j + 1);
                if(isPalin(subs)) {
                    max = max.length() <= subs.length() ? subs : max;
                    break;
                }
            }
        }
        
        return max;
    }
    
    public boolean isPalin(String s) {
        if(s == null || s.length() == 0)    return true;
        for(int i = 0, j = s.length() - 1; i <= j && i < s.length() && j >= 0; i++, j--) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
    
    //from middle to 2 directions
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0)    return "";
        String max = "";
        
        for(int i = 0; i < s.length(); i++) {
            String s1 = findPalin(s, i, i);
            String s2 = findPalin(s, i, i + 1);
            
            if(s1.length() > s2.length()) {
                max = s1.length() > max.length() ? s1 : max;
            } else {
                max = s2.length() > max.length() ? s2 : max;
            }
        }
        return max;
    }
    
    public String findPalin(String s, int m1, int m2) {
        if(s == null || s.length() == 0 || m1 > m2) return "";
        for(; m1 >= 0 && m2 < s.length(); m1--, m2++) {
            if(s.charAt(m1) != s.charAt(m2)) {
                break;
            }
        } 
        return s.substring(m1 + 1, m2);
    }
}
